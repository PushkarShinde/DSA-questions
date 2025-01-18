class Solution {
public:
    long reverse(int x) {
        long result = 0;
        while (x != 0) {
            int digit = x % 10;
            result = result * 10 + digit; // wow!!
            x /= 10;

            if (result > INT_MAX || result < INT_MIN) {
                return 0; // Return 0 in case of overflow
            }
        }
        return result;
    }
};