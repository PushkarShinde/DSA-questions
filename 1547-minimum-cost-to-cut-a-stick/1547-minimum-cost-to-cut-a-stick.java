class Solution {
    int[][] dp;
    int[] a;
    public int minCost(int m, int[] cuts){
        int n=cuts.length;
        a=new int[n+2];
        a[0]=0; a[n+1]=m;
        for(int i=1;i<n+1;i++){
            a[i]=cuts[i-1];
        }
        Arrays.sort(a);
        dp=new int[n+2][n+2];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return solve(0,n+1);
    }
    private int solve(int i, int j){
        int n=a.length;
        if(j-i<2) return dp[i][j]=0;
        if(dp[i][j]!=-1) return dp[i][j];
        int res=(int)1e9;
        for(int k=i+1;k<j;k++){
            res=Math.min(res, solve(i, k)+solve(k, j)+(a[j]-a[i]));
        }
        return dp[i][j]=res;
    }
}