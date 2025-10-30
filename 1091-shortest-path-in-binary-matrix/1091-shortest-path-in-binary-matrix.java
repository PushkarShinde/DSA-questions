class Solution {
    int[][] dir={{-1,0},{-1,-1},{-1,1}, {0,-1}, {0,1},{1,-1},{1,1}, {1,0}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1; 
        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][m];
        q.offer(new int[]{0,0, 1});
        vis[0][0]=true;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int i=cur[0], j=cur[1], dist=cur[2];
            if(i==n-1 && j==m-1) return dist;
            for(int[] d: dir){
                int x=i+d[0], y=j+d[1];
                if(x<0 || y<0 || x>=n || y>=m || grid[x][y]!=0 || vis[x][y]){
                    continue;
                }
                vis[x][y]=true;
                q.offer(new int[]{x,y, dist+1});
            }
        }
        return -1;
    }
}