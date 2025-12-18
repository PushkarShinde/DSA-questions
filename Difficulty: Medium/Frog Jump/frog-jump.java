class Solution {
    int minCost(int[] height) {
        int n=height.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,dp,height);
    }
    private int solve(int n, int[] dp,int[] height){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int left=solve(n-1,dp,height)+Math.abs(height[n]-height[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1) right=solve(n-2,dp,height)+Math.abs(height[n]-height[n-2]);
        dp[n]=Math.min(left, right);
        return dp[n];
    }
}