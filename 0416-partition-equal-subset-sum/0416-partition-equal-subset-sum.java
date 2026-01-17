class Solution {
    private int[][] dp;
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0) return false;
        sum=sum/2;
        int n=nums.length;
        dp=new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums, 0, 0, sum);
    }
    private boolean solve(int[] nums, int curSum, int i, int sum){
        if(curSum==sum) return true;
        if(curSum>sum) return false;
        if(dp[i][curSum]!=-1) return dp[i][curSum]==1;
        boolean res=false;
        if(i<nums.length){
            res |= solve(nums, curSum+nums[i], i+1, sum);
            res |= solve(nums, curSum, i+1, sum);
        }
        dp[i][curSum]=res?1:0;
        return res;
    }
}