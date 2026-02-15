class Solution {
    int[][] dp;
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int res=0;
        dp=new int[m][n];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    res+=solve(matrix, i,j);
                }
            }
        }
        return res;
    }
    private int solve(int[][] grid, int i, int j){
        int m=grid.length;
        int n=grid[0].length;
        if(i>=m || j>=n || grid[i][j]==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=solve(grid, i+1,j);
        int diag=solve(grid, i+1,j+1);
        int left=solve(grid, i,j+1);
        return dp[i][j]=1+Math.min(right, Math.min(left, diag));
    }
}