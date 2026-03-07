class Solution {
    static int[][] dp;
    static int noOfWays(int m, int n, int x) {
        dp=new int[n+1][x+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        // for(int i=1;i<=m;i++){
        //     dp[1][i]=1;
        // }
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<m;j++){
                
        //     }
        // }
        return solve(m,n,x);
    }
    private static int solve(int m, int n, int x){
        if(n==0 && x==0) return 1;
        if(n<0 || x<0) return 0;
        if(dp[n][x]!=-1) return dp[n][x];
        int ways=0;
        for(int i=1;i<=m;i++){
            ways+=solve(m,n-1,x-i);
        }
        return dp[n][x]=ways;
    }
};