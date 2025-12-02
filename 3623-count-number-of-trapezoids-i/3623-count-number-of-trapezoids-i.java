class Solution {
    private static int MOD=1000_000_007; 
    public int countTrapezoids(int[][] points) {
        // Step 1: Map y -> List of x-coordinates
        Map<Integer, List<Integer>> yMap = new HashMap<>();
        for (int[] p : points) {
            yMap.computeIfAbsent(p[1], k -> new ArrayList<>()).add(p[0]);
        }

        // Step 2: For each y-level, calculate number of horizontal segments (C(n, 2))
        List<Long> segments = new ArrayList<>();
        for (List<Integer> xs:yMap.values()) {
            int n = xs.size();
            if (n >= 2) {
                long c2 = (long) n * (n - 1) / 2;
                segments.add(c2);
            }
        }

        // Step 3: Use formula: (S^2 - sum_of_squares) / 2
        long sum = 0, sumSq = 0;
        for (long val : segments) {
            sum = (sum + val) % MOD;
            sumSq = (sumSq + (val * val) % MOD) % MOD;
        }

        // Calculate result
        long result = (sum * sum % MOD - sumSq + MOD) % MOD;
        result = result * inv(2) % MOD;  // divide by 2 using modular inverse

        return (int) result;
    }

    // Modular inverse of 2 mod 10^9+7 is 500000004
    private long inv(long a) {
        return pow(a, MOD - 2);
    }

    private long pow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) != 0) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
    // private int comb(int n){
    //     if(n<=2) return 1;
    //     int prod=n*(n-1)/2;
    //     return prod;
    // }

    /**
Instead of doing:
for (int i = 0; i < ys.size(); i++)
    for (int j = i + 1; j < ys.size(); j++)
        res += segCount[ys[i]] * segCount[ys[j]];
We can avoid the O(n²) nested loop by using the following observation:

✅ Mathematical Trick
Let segmentCounts = [a₁, a₂, ..., aₙ]
You want to compute:

sum_{i < j} (aᵢ * aⱼ)
(S² - sum_of_squares) / 2
Where:
S = a₁ + a₂ + ... + aₙ
sum_of_squares = a₁² + a₂² + ... + aₙ²

This trick reduces the complexity from O(n²) to O(n)!
    
    */
}