public class Solution {
    public int numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long S = Long.parseLong(s);
        int lenS = s.length();
        int count = 0;

        // Check if S itself is within the range
        if (S >= start && S <= finish) {
            count++;
        }

        String finishStr = Long.toString(finish);
        int finishLen = finishStr.length();

        // If s is longer than finish, no possible numbers
        if (lenS > finishLen) {
            return count;
        }

        int maxLenP = finishLen - lenS;
        if (maxLenP < 1) {
            return count;
        }

        long tenLenS = (long) Math.pow(10, lenS);

        for (int lenP = 1; lenP <= maxLenP; lenP++) {
            int currentLenX = lenP + lenS;
            if (currentLenX > finishLen) {
                continue;
            }

            long minP = (long) Math.pow(10, lenP - 1);
            long maxP = (limit * ((long) Math.pow(10, lenP) - 1)) / 9;

            long minX = minP * tenLenS + S;
            long maxX = maxP * tenLenS + S;

            if (maxX < start || minX > finish) {
                continue;
            }

            long lowerPX = (start - S + tenLenS - 1) / tenLenS; // ceil((start - S)/tenLenS)
            long upperPX = (finish - S) / tenLenS;

            long lowerP = Math.max(lowerPX, minP);
            long upperP = Math.min(upperPX, maxP);

            if (lowerP > upperP) {
                continue;
            }

            String upperPStr = String.format("%0" + lenP + "d", upperP);
            String lowerPStr = String.format("%0" + lenP + "d", lowerP);

            int cntUpper = countValidNumbers(upperPStr, lenP, limit);
            int cntLower = (lowerP > 1) ? countValidNumbers(String.format("%0" + lenP + "d", lowerP - 1), lenP, limit) : 0;

            count += cntUpper - cntLower;
        }

        return count;
    }

    private int countValidNumbers(String X, int lenP, int limit) {
        int n = X.length();
        if (n < lenP) {
            return 0;
        }
        if (n > lenP) {
            // All lenP-digit numbers with digits <= limit and first digit >=1
            int total = limit; // first digit: 1..limit
            for (int i = 1; i < lenP; i++) {
                total *= (limit + 1); // other digits: 0..limit
            }
            return total;
        }

        // X has exactly lenP digits
        int[][][] dp = new int[lenP + 1][2][2];
        dp[0][1][0] = 1; // position 0, tight=1, nonZero=0

        for (int i = 0; i < lenP; i++) {
            for (int tight = 0; tight < 2; tight++) {
                for (int nonZero = 0; nonZero < 2; nonZero++) {
                    if (dp[i][tight][nonZero] == 0) {
                        continue;
                    }

                    int maxDigit = (tight == 1) ? (X.charAt(i) - '0') : 9;
                    for (int d = 0; d <= maxDigit; d++) {
                        if (nonZero == 0) {
                            if (d == 0) {
                                // Continue with nonZero=0
                                int newTight = (tight == 1 && d == maxDigit) ? 1 : 0;
                                dp[i + 1][newTight][0] += dp[i][tight][nonZero];
                            } else {
                                // First non-zero digit
                                if (d > limit || (i == 0 && d < 1)) {
                                    continue;
                                }
                                int newTight = (tight == 1 && d == maxDigit) ? 1 : 0;
                                dp[i + 1][newTight][1] += dp[i][tight][nonZero];
                            }
                        } else {
                            if (d > limit) {
                                continue;
                            }
                            int newTight = (tight == 1 && d == maxDigit) ? 1 : 0;
                            dp[i + 1][newTight][1] += dp[i][tight][nonZero];
                        }
                    }
                }
            }
        }

        return dp[lenP][0][1] + dp[lenP][1][1];
    }
}
