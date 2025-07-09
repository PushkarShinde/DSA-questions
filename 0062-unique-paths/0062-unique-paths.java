class Solution {
/*
    //TOP DOWN APPROACH
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int[] rows: dp){
            Arrays.fill(rows,-1);
        }
        return solve(m,n,dp);
    }
    private int solve(int m, int n, int[][] dp){
        if(n==1 || m==1) return 1;
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n]=uniquePaths(m,n-1) + uniquePaths(m-1, n);
    }
*/
    // BOTTOM UP APPROACH
    public int uniquePaths(int m, int n){
        int[][] dp=new int[m][n];
        // fill the first row and column with 1
        for(int i=0;i<m;i++) dp[i][0]=1;
        for(int i=0;i<n;i++) dp[0][i]=1;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}