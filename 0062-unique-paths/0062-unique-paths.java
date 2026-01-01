class Solution {
    private int[][] dp;
    public int uniquePaths(int m, int n) {
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(m,n, 0,0);
    }
    int[][] dir={{0,1},{1,0}};
    private int solve(int m, int n, int i, int j){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int ways=0;
        for(int[] d:dir){
            int nx=i+d[0], ny=j+d[1];
            if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
            ways+=solve(m,n,nx,ny);
        }
        return dp[i][j]=ways;
    }
}