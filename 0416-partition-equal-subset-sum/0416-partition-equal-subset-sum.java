class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0) return false;
        sum=sum/2;
        return solve(nums, 0, 0, sum);
    }
    private boolean solve(int[] nums, int curSum, int i, int sum){
        if(curSum==sum) return true;
        if(curSum>sum) return false;
        boolean res=false;
        if(i<nums.length){
            res |= solve(nums, curSum+nums[i], i+1, sum);
            res |= solve(nums, curSum, i+1, sum);
        }
        return res;
    }
}