class Solution {
    int[] a, b;
    int[][][] dp;
    public int maxDotProduct(int[] a, int[] b) {
        int n=a.length;
        int m=b.length;
        this.a=a;
        this.b=b;
        int k=n-m;
        
        dp=new int[n+1][m+1][k+1];
        for(int[][] dk:dp){
            for(int[] d:dk){
                Arrays.fill(d,-1);
            }
        }
        return solve(n,m,k);
    }
    
    private int solve(int i, int j, int k){
        if(i<=0 || j<=0) return 0;  
        
        if(dp[i][j][k]!=-1) return dp[i][j][k];

        int pick=a[i-1]*b[j-1]+solve(i-1, j-1,k);
        int skip=0;
        if(k>0){
            skip=solve(i-1, j,k-1);
        }
        
        return dp[i][j][k]=Math.max(pick, skip);
    }
}