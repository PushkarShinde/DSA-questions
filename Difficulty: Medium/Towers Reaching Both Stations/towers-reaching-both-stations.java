class Solution {
    int n, m;
    boolean[][] reachp, reachq;
    int[][] mat;
    public int countCoordinates(int[][] mat) {
        this.mat=mat;
        n=mat.length;
        m=mat[0].length;
        int count=0;
        reachp=new boolean[n][m];
        reachq=new boolean[n][m];
        
        Queue<int[]> qp=new ArrayDeque<>();
        Queue<int[]> qq=new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            qp.offer(new int[]{i,0});
            reachp[i][0]=true;
            
            qq.offer(new int[]{i,m-1});
            reachq[i][m-1]=true;
        }
        for(int j=0;j<m;j++){
            qp.offer(new int[]{0,j});
            reachp[0][j]=true;
            
            qq.offer(new int[]{n-1,j});
            reachq[n-1][j]=true;
        }
        
        bfs(qp,reachp);
        bfs(qq,reachq);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(reachp[i][j] && reachq[i][j]){
                    count++;   
                }
            }
        }
        return count;
    }
    int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    
    private void bfs(Queue<int[]> q, boolean[][] reach){
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int r=cur[0];
            int c=cur[1];
            
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || reach[nr][nc]) {
                    continue;
                }
                
                if (mat[nr][nc] >= mat[r][c]) {
                    reach[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}