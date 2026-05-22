class Solution {
    int cntOnes(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int res=0;
        boolean[][] vis=new boolean[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    int[] info=dfs(grid, vis, i,j);
                    
                    int size=info[0];
                    int boundary=info[1];
                    
                    if(boundary==0){
                        res+=size;
                    }
                }
            }
        }
        return res;
    }
    
    private int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
    private int[] dfs(int[][] a, boolean[][] vis, int i, int j){
        int n=a.length;
        int m=a[0].length;
        
        vis[i][j]=true;
        
        int size=1;
        int boundary=(i==0 || j==0 || i==n-1 || j==m-1)?1:0;
        
        for(int[] d:dir){
            int x=i+d[0];
            int y=j+d[1];
            if(x<0 || y<0 || x>=n || y>=m || vis[x][y] || a[x][y]==0){
                continue;
            }
            int[] next=dfs(a,vis,x,y);
            size+=next[0];
            boundary |= next[1];
        }
        return new int[]{size, boundary};
    }
};