class Solution {
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        int low = 1, high = *max_element(nums.begin(), nums.end());
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            int operations = 0;

            // Calculate total operations needed to make all bag sizes <= mid
            for (int num : nums) {
                operations += (num - 1) / mid; // (num - 1) / mid splits `num` into parts <= mid
            }

            if (operations > maxOperations) {
                low = mid + 1; // Too many operations, increase penalty
            } else {
                high = mid; // Operations are within limits, try smaller penalty
            }
        }
        
        return low; // Minimum possible penalty
    }
};