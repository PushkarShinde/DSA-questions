class Solution {
    int[][] dp;
    public int knapSack(int val[], int wt[], int capacity) {
        int n=wt.length;
        dp=new int[n+1][capacity+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(val, wt, capacity, n);
    }
    private int solve(int val[], int wt[], int W, int n){
        if(W==0 || n==0)return 0;
        if(wt[n-1]>W) return solve(val, wt, W, n-1);
        if(dp[n][W]!=-1) return dp[n][W];
        int include=val[n-1]+solve(val, wt, W-wt[n-1], n);
        int exclude=solve(val, wt, W, n-1);
        return dp[n][W]=Math.max(include, exclude);
    }
}