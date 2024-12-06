class Solution {
public:
    int maxCount(vector<int>& banned, int n, int maxSum) {
        int count = 0, sum = 0;

        for (int i = 1; i <= n; i++) {
            // Check if the number is banned
            bool inBanned = false;
            for (int j = 0; j < banned.size(); j++) {
                if (banned[j] == i) {
                    inBanned = true;
                    break;
                }
            }

            if (!inBanned && sum + i <= maxSum) {
                sum += i;
                count++;
            } else if (sum + i > maxSum) {
                break; // Stop if adding the number exceeds maxSum
            }
        }

        return count;
    }
};
