class Solution {
    int n;
    int[][] dp;
    public int paintWalls(int[] cost, int[] time) {
        this.n=cost.length;
        dp=new int[n][n+1];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }
        return solve(cost, time, 0, n);
    }
    private int solve(int[] costs, int[] times, int i, int remaining){
        if(remaining<=0) return 0;
        if(i==n) return (int)1e9;
        if(dp[i][remaining]!=-1) return  dp[i][remaining];

        int take=costs[i]+solve(costs, times, i+1, 
                                Math.max(0,remaining-times[i]-1));
        int skip=solve(costs, times, i+1, remaining);

        return dp[i][remaining]=Math.min(take, skip);
    }
}