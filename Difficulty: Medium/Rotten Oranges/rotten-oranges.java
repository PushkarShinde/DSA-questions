class Solution {
    public int orangesRot(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        // boolean[][] vis=new boolean[n][m];
        
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==2)
                    q.offer(new int[]{i,j});
            }
        }
        
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            boolean rotted=false;
            while(size-->0){
                int[] cur=q.poll();
                int x=cur[0];
                int y=cur[1];
                mat[x][y]=0;
                for(int[] d:dir){
                    int nx=x+d[0];
                    int ny=y+d[1];
                    
                    if(nx<0 || ny<0 || nx>=n || ny>=m || mat[nx][ny]==0 || mat[nx][ny]==2) continue;
                    
                    rotted=true;
                    mat[nx][ny]=2;
                    q.offer(new int[]{nx,ny});
                }
            }
            if(rotted) count++;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1) return -1;
            }
        }
        
        return count;
    }
}