class Solution {
    int n, m;
    int[][] grid;

    public int minDays(int[][] grid) {
        this.grid=grid;
        n=grid.length;
        m=grid[0].length;

        boolean[][] vis=new boolean[n][m];
        int count=countIsland(vis);
        if(count==0 || count>1) return 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    vis=new boolean[n][m];
                    grid[i][j]=0;
                    count=countIsland(vis);
                    grid[i][j]=1;

                    if(count==0) return 1;
                    if(count>1) return 1;
                }
            }
        }
        return 2;
    }

    private int countIsland(boolean[][] vis){
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    dfs(i, j, vis);
                    count++;
                }
            }
        }
        return count;
    }

    private int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    private void dfs(int i, int j, boolean[][] vis){
        for(int[] d:dir){
            int nx=i+d[0];
            int ny=j+d[1];
            if(nx<0 || ny<0 || nx>=n || ny>=m || grid[nx][ny]==0 || vis[nx][ny]) {
                continue;
            }
            vis[nx][ny]=true;
            dfs(nx,ny, vis);
        }
    }
}