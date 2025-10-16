class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        boolean[][] vis=new boolean[m][n];
        int[][] dist=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j, 0});
                }
            }
        }
        int[][] dir={{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x=cur[0];
            int y=cur[1];
            int distance=cur[2];
            vis[x][y]=true;
            dist[x][y]=distance;
            for(int[] d: dir){
                int nx=x+d[0];
                int ny=y+d[1];
                if(nx>=m || ny>=n || nx<0 || ny<0 || vis[nx][ny] || mat[nx][ny]==0) continue;
                dist[nx][ny]=distance+1;
                vis[nx][ny]=true;
                q.offer(new int[]{nx,ny,distance+1});
            }
        }
        return dist;
    }
}