class Solution {
public:
    string reverseWords(string s) {
        vector<string> str; // To store individual words
        int i = 0, n = s.length();

        // Split the string into words
        while (i < n) {
            while (i < n && s[i] == ' ') { // Skip leading spaces
                i++;
            }
            if (i < n) {
                int start = i;
                while (i < n && s[i] != ' ') { // Find the end of the word
                    i++;
                }
                str.push_back(s.substr(start, i - start)); // Extract the word
            }
        }

        // Reverse the words and construct the result
        string result;
        for (int k = str.size() - 1; k >= 0; k--) {
            result += str[k];
            if (k != 0) { // Add a space between words
                result += " ";
            }
        }

        return result;
    }
};