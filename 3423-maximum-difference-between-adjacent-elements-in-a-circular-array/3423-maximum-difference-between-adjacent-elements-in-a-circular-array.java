class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n=nums.length;
        int maxDiff=Math.abs(nums[0]-nums[n-1]); // first n last ka pehle hi le liya diff
        for(int i=1;i<n;i++){
            maxDiff=Math.max(maxDiff,Math.abs(nums[i-1]-nums[i]));
        }
        return maxDiff;
    }
}