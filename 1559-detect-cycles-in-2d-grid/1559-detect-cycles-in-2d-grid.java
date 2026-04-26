class Solution {
    char[][] grid;
    int n;
    int m;
    boolean[][] vis;
    public boolean containsCycle(char[][] grid) {
        this.grid=grid;
        this.n=grid.length;
        this.m=grid[0].length;
        vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    if(dfs(i,j, -1, -1)) return true; 
                }
            }
        }
        return false;
    }

    int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    private boolean dfs(int i, int j, int px, int py){
        vis[i][j]=true;

        char pre=grid[i][j];
        for(int[] d:dir){
            int nx=i+d[0];
            int ny=j+d[1];
            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
            char cur=grid[nx][ny];
            if(pre!=cur) continue;
            if(vis[nx][ny]){//parent toh nahi
                if(nx!=px || ny!=py) return true;
            }else{
                if(dfs(nx, ny, i, j)) return true;
            }
            
        }

        return false;
    }
}