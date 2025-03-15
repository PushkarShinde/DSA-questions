class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int left = 1;  // Minimum possible capability
        int right = 0; // Maximum possible capability
        
        // Find the maximum value in nums as the upper bound
        for (int num : nums) {
            right = Math.max(right, num);
        }
        
        // Binary search on the capability
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Check if we can rob at least k houses with capability <= mid
            if (canRobK(nums, k, mid)) {
                right = mid; // Try a smaller capability
            } else {
                left = mid + 1; // Need a larger capability
            }
        }
        
        return left;
    }
    
    private boolean canRobK(int[] nums, int k, int cap) {
        int count = 0; // Number of houses we can rob
        int i = 0;
        int n = nums.length;
        
        // Greedily rob houses
        while (i < n) {
            if (nums[i] <= cap) {
                count++; // Rob this house
                i += 2;  // Skip the next house
            } else {
                i++; // Skip this house
            }
            if (count >= k) return true; // Early exit if we reach k
        }
        
        return count >= k;
    }
}