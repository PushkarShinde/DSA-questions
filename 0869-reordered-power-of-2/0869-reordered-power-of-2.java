class Solution {
    public boolean reorderedPowerOf2(int n) {
        // Count digit frequencies of n
        int[] countN = countDigits(n);

        // Check all powers of 2 up to 2^30 (because 10^9 < 2^31)
        for (int i = 0; i < 31; i++) {
            int powerOfTwo = 1 << i;
            if (areCountsEqual(countN, countDigits(powerOfTwo))) {
                return true;
            }
        }
        return false;
    }

    // Helper function to count digits of a number
    private int[] countDigits(int num) {
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        return count;
    }

    // Compare two digit count arrays
    private boolean areCountsEqual(int[] count1, int[] count2) {
        for (int i = 0; i < 10; i++) {
            if (count1[i] != count2[i]) return false;
        }
        return true;
    }
}