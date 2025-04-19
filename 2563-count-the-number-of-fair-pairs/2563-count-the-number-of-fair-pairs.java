class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        // wow, maza aya!
        Arrays.sort(nums);
        int n=nums.length;
        long count=0;
        for(int i=0;i<n-1;i++){
            int lo=lower-nums[i];
            int up=upper-nums[i];
            int left=lowerBound(nums, i+1, n-1, lo);
            int right=upperBound(nums, i+1, n-1, up);
            if(left<=right && left < n && right < n && left >= i + 1 && right >= i + 1){
                count+=(right-left+1);
            }
        }
        return count;       
    }
    // First index where nums[idx] >= target
    private int lowerBound(int[] nums, int l, int r, int t){
        int ans = r + 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] >= t){
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
    // Last index where nums[idx] <= target
    private int upperBound(int[] nums, int l, int r, int t){
        int ans = l - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] <= t){
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans; // returns valid index or i-1 if no match
    }
}