class Solution {
    public int maxSubArray(int[] nums) {
        /* MOST OPTIMAL 
        KANADE ALGORITHM */
        int curSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            curSum+=nums[i];
            maxSum=Math.max(maxSum,curSum);
            if(curSum<0) curSum=0;
        }
        return maxSum;
    }
}