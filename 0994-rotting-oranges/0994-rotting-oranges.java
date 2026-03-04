class Solution {
    public int orangesRotting(int[][] grid) {
        int time=0;
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;

        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) q.offer(new int[]{i,j});
                if(grid[i][j]==1) fresh++;
            }
        }

        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size=q.size();
            boolean rotted=false;
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                int x=cur[0], y=cur[1];
                for(int[] d:dir){
                    int nx=x+d[0], ny=y+d[1];
                    if(nx<0 || ny<0 || nx>=m || ny>=n || grid[nx][ny]==0 || grid[nx][ny]==2) continue;
                    grid[nx][ny]=2;
                    q.offer(new int[]{nx,ny});
                    fresh--;
                    rotted=true;
                }
            }
            if(rotted) time++;
        }

        return fresh==0?time:-1;
    }
}