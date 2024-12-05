class Solution {
public:
    bool canChange(string start, string target) {
        string startFiltered, targetFiltered;
        for (char c : start) {
            if (c != '_') startFiltered += c;
        }
        for (char c : target) {
            if (c != '_') targetFiltered += c;
        }
        
        if (startFiltered != targetFiltered) return false;

        // Check movement constraints
        int n = start.length();
        int i = 0, j = 0;

        while (i < n && j < n) {
            // Find the next non-blank character in both strings
            while (i < n && start[i] == '_') i++;
            while (j < n && target[j] == '_') j++;

            // If one string reaches the end but the other doesn't
            if (i == n || j == n) break;

            // Check constraints
            if (start[i] != target[j]) return false;
            if (start[i] == 'L' && i < j) return false; 
            if (start[i] == 'R' && i > j) return false; 

            // Move to the next character
            i++;
            j++;
        }

        return true;
    }
};