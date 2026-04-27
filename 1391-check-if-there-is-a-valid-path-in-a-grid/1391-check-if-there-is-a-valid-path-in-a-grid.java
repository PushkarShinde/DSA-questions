class Solution {
    int[][] grid;
    int n;
    int m;
    boolean[][] vis;
    public boolean hasValidPath(int[][] grid) {
        this.grid=grid;
        this.n=grid.length;
        this.m=grid[0].length;
        vis=new boolean[n][m];
        return solve(0,0);
    }
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};//R, L, D, U
    int[][] bounds={{},{0,1},{2,3},{1,2},{0,2},{1,3},{0,3}};
    private boolean solve(int i, int j){
        if(i==n-1 && j==m-1) return true;

        vis[i][j]=true;
        int ind=grid[i][j];
        int[] ways=bounds[ind];
        for(int w:ways){
            int nx=i+dir[w][0];
            int ny=j+dir[w][1];
            if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
            if(vis[nx][ny]) continue;

            int opposite=(w == 0 ? 1 : w == 1 ? 0 : w == 2 ? 3 : 2);
            boolean back=false;

            for(int r:bounds[grid[nx][ny]]){
                if(r==opposite){
                    back=true;
                    break;
                }
            }
            if(!back) continue;

            if(solve(nx, ny)) return true;
        }

        return false;
    }
}