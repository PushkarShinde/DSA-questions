class Solution {
    private int[][] dir={{0,1},{1,0}};
    private int[][] dp;
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(grid, 0,0);
    }
    private int solve(int[][] grid, int i, int j){
        int m=grid.length;
        int n=grid[0].length;
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int minSum=Integer.MAX_VALUE;
        int num=grid[i][j];
        for(int[] d:dir){
            int x=i+d[0], y=j+d[1];
            if(x<0 || y<0 || x>=m || y>=n) continue;
            minSum=Math.min(minSum,num+solve(grid, x,y));
        }
        return dp[i][j]=minSum;
    }
}