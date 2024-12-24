class Solution {
public:
    int minimumMoves(string s) {
        int count = 0;
        for (int i = 0; i < s.size(); ) {
            if (s[i] == 'X') {
                count++;        // Increment the move count
                i += 3;         // Skip the next 2 characters as they will be flipped to 'O'
            } else {
                i++;            // Move to the next character
            }
        }
        return count;
    }
};