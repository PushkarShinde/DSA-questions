class Solution {
    int[] nums;
    int[][] dp;
    int n;
    public int lengthOfLIS(int[] nums) {
        this.nums=nums;
        n=nums.length;
        dp=new int[n][n+1];
        for(int[] i:dp) Arrays.fill(i, -1);
        return solve(0,-1);
    }
    private int solve(int i, int pre){
        if(i==n) return 0;
        if(dp[i][pre+1]!=-1) return dp[i][pre+1];
        int nottake=solve(i+1, pre);
        int take=0;
        if(pre==-1 || nums[i]>nums[pre]){
            take=1+solve(i+1, i);
        }
        return dp[i][pre+1]=Math.max(take, nottake);
    }
}