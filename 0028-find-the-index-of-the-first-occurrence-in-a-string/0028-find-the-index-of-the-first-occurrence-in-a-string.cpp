class Solution {
public:
    int strStr(string haystack, string needle) {
        // return haystack.find(needle);
        int n=haystack.length();
        int m=needle.length();
        if (m == 0) return 0;
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (haystack[i + j] != needle[j]) {
                    break; 
                }
            }
            if (j == m) { 
                return i;
            }
        }
        return -1; // No match found
    }
};