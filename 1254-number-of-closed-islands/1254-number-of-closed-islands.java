class Solution {
    int n, m;
    int[][] grid;
    boolean closed;

    public int closedIsland(int[][] grid) {
        this.grid=grid;
        n=grid.length;
        m=grid[0].length;

        boolean[][] vis=new boolean[n][m];
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]==0){
                    closed=true;
                    dfs(i,j,vis);
                    if(closed) count++;
                }
            }
        }

        return count;
    }
    private int[][] dir={{-1,0}, {1,0}, {0,1}, {0,-1}};
    private void dfs(int x, int y, boolean[][] vis){
        vis[x][y]=true;
        if(x==0 || y==0 || x==n-1 || y==m-1) closed=false;

        for(int[] d:dir){
            int nx=x+d[0];
            int ny=y+d[1];

            if(nx>=n || ny>=m || nx<0 || ny<0 || grid[nx][ny]==1 || vis[nx][ny]) continue;

            dfs(nx, ny, vis);
        }
    }
}