class Solution {
    public int divide(int dividend, int divisor) {

        // WOW
        if (dividend == divisor) return 1;

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long res = 0;

        while (a >= b) {
            int power = 0;
            while (a >= (b << (power + 1))) {
                power++;
            }
            a -= (b << power);
            res += (1L << power);
        }

        // Apply sign
        if ((dividend < 0) ^ (divisor < 0)) res = -res;

        // Clamp to 32-bit signed int range
        if (res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) res;
    }
}