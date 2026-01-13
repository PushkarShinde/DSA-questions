class Solution {
    int[][][] dp;
    public int maxChocolate(int grid[][]) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(grid,0,0,m-1);
    }
    private int solve(int[][] grid, int r, int c1, int c2){
        int n=grid.length;
        int m=grid[0].length;
        if(r>=n) return 0;
        if(dp[r][c1][c2]!=-1) return dp[r][c1][c2];
        int cherry=grid[r][c1];
        if(c1!=c2) cherry+=grid[r][c2];
        int ans=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int x=r+1;
                int y1=c1+i;
                int y2=c2+j;
                if(y1<0 || y2<0 || y1>=m || y2>=m) continue;
                ans=Math.max(ans,solve(grid,x,y1,y2));
            }
        }
        return dp[r][c1][c2]=ans+cherry;
    }
}