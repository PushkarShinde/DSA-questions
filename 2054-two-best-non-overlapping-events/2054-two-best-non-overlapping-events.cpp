class Solution {
public:
    int maxTwoEvents(vector<vector<int>>& events) {
        // Sort events by their end times
        sort(events.begin(), events.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1]; // Sort by end time
        });

        int n = events.size();
        vector<int> maxValues(n); // Prefix maximum array
        maxValues[0] = events[0][2]; // Initialize with the first event's value

        // Fill the prefix maximum array
        for (int i = 1; i < n; ++i) {
            maxValues[i] = max(maxValues[i - 1], events[i][2]);
        }

        int maxSum = 0;

        // Iterate through all events
        for (int i = 0; i < n; ++i) {
            // Find the latest non-overlapping event using binary search
            int left = 0, right = i - 1, prev = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][1] < events[i][0]) { // Check if non-overlapping
                    prev = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // Calculate maximum sum
            int currSum = events[i][2]; // Take the current event's value
            if (prev != -1) {
                currSum += maxValues[prev]; // Add the best non-overlapping event
            }
            maxSum = max(maxSum, currSum); // Update the maximum sum
        }

        return maxSum;
    }
};