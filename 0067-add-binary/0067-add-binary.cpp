class Solution {
public:
    string addBinary(string a, string b) {
        string result = "";
        int i = a.size() - 1, j = b.size() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry) {
            int sum = carry;
            if (i >= 0) {
                sum += a[i] - '0';
                i--;
            }
            if (j >= 0) {
                sum += b[j] - '0';
                j--;
            }
            result += (sum % 2) + '0';  // Add the binary digit
            carry = sum / 2;            // Compute the carry
        }
        reverse(result.begin(), result.end());
        return result;
    }
};