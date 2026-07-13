class Solution {
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        if(mat[xs][ys]==0 || mat[xd][yd]==0) return -1;
        dfs(mat, xs,ys,xd,yd,0);
        return res;
    }
    
    int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    int res=0;
    private void dfs(int[][] mat, int i, int j, int xd, int yd, int count) {
        int n=mat.length;
        int m=mat[0].length;
        
        if(i==xd && j==yd){
            res=Math.max(res, count);
            return;
        }
        
        mat[i][j]=0;
        int score=1;
        for(int[] d:dir){
            int x=i+d[0];
            int y=j+d[1];
            
            if(x<0 || y<0 || x>=n || y>=m || mat[x][y]==0) continue;
            dfs(mat,x,y,xd,yd,count+1);
        }

        mat[i][j]=1;
    }
}