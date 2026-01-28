class Solution {
    private int[][] dp;
    public int cutRod(int[] price){
        int n=price.length;
        dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(price, 0, n);
    }
    private int solve(int[] a, int i, int n){
        if(i==a.length || n==0) return 0;
        if(dp[i][n]!=-1) return dp[i][n];
        int include=Integer.MIN_VALUE;
        int rod=i+1;
        if(rod<=n) include=a[i]+solve(a, i, n-rod);
        int exclude=solve(a, i+1, n);
        return dp[i][n]=Math.max(include, exclude);
    }
}