class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            if(grid[i][0]==1 && !vis[i][0]) dfs(vis,grid,i,0);
            if(grid[i][n-1]==1 && !vis[i][n-1]) dfs(vis,grid,i,n-1);
        }
        for(int j=0;j<n;j++){
            if(grid[0][j]==1 && !vis[0][j]) dfs(vis,grid,0,j);
            if(grid[m-1][j]==1 && !vis[m-1][j]) dfs(vis,grid,m-1,j);
        }
        int res=0;
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(grid[i][j]==1 && !vis[i][j]) res++;
            }
        }
        return res;
    }
    int[][] dir={{0,-1}, {0,1}, {1,0}, {-1,0}};
    private void dfs(boolean[][] vis,int[][] grid,int i, int j){
        int m=grid.length;
        int n=grid[0].length;
        if(i>m-1 || j>n-1 || i<0 || j<0 || vis[i][j] || grid[i][j]==0) return;
        vis[i][j]=true;
        for(int[] d: dir){
            int nx=i+d[0];
            int ny=j+d[1];
            dfs(vis, grid, nx, ny);
        }
    }
}