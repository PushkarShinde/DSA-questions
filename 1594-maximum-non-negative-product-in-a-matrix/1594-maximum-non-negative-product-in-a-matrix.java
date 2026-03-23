class Solution {
    private int mod=(int)1e9+7;
    int n, m;
    private boolean[][] vis;
    private long[][] minDp;
    private long[][] maxDp;
    public int maxProductPath(int[][] grid) {
        this.n=grid.length;
        this.m=grid[0].length;
        if(n==1 && m==1) return grid[0][0];

        minDp=new long[n][m];
        maxDp=new long[n][m];
        vis=new boolean[n][m];

        dfs(grid, 0,0);
        long ans=maxDp[0][0];
        return ans<0?-1:(int)(ans%mod);
    }

    private long[] dfs(int[][] grid, int i, int j){
        if(i==n-1 && j==m-1){
            return new long[]{grid[i][j], grid[i][j]};
        }
        if(vis[i][j]){
            return new long[]{minDp[i][j], maxDp[i][j]};
        }

        long maxVal=Long.MIN_VALUE;
        long minVal=Long.MAX_VALUE;

        int[][] dir={{0,1},{1,0}};
        for(int[] d:dir){
            int nx=i+d[0], ny=j+d[1];
            if(nx<0 || ny<0 || nx>=n || ny>=m) continue;

            long[] next=dfs(grid, nx,ny);
            long a=grid[i][j]*next[0];
            long b=grid[i][j]*next[1];

            minVal=Math.min(minVal, Math.min(a,b));
            maxVal=Math.max(maxVal, Math.max(a,b));
        }
        
        vis[i][j]=true;
        minDp[i][j]=minVal;
        maxDp[i][j]=maxVal;

        return new long[]{minVal, maxVal};
    }
}