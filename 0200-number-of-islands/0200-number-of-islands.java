class Solution {
    boolean[][] vis;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        int islands=0;
        m=grid.length;
        n=grid[0].length;
        vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    dfs(grid, i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
    int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    private void dfs(char[][] grid, int i, int j){
        vis[i][j]=true;
        for(int[] d:dir){
            int nx=i+d[0];
            int ny=j+d[1];
            if(nx<0 || ny<0 || nx>=m || ny>=n || grid[nx][ny]=='0' || vis[nx][ny]) continue;
            dfs(grid, nx, ny);
        }
    }
}