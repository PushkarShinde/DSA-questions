class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        int n=nums.length;
        dp=new int[n+1][2];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return Math.max(solve(nums, 0,1), solve(nums, 0,0));
    }
    private int solve(int[] nums, int i, int take){
        if(i==nums.length) return 0;
        if(dp[i][take]!=-1) return dp[i][take];
        if(take==1) return dp[i][take]=solve(nums, i+1, 0);
        return dp[i][take]=Math.max(nums[i]+solve(nums, i+1, 1), 
                                solve(nums, i+1,0));
    }
}