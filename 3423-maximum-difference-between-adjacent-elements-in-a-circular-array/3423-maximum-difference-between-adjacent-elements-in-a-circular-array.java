class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n=nums.length;
        int maxDiff=Integer.MIN_VALUE;
        for(int i=1;i<2*n;i++){
            maxDiff=Math.max(maxDiff,Math.abs(nums[(i-1)%n]-nums[i%n]));
        }
        return maxDiff;
    }
}