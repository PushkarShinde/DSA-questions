class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> qu=new LinkedList<>();
        int fresh=0, minutes=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) qu.offer(new int[]{i,j});
                //this way hum pehle hi base level bana rahe h, for minute 0.
                else if(grid[i][j]==1) fresh++;
                //this way hume pata hoga ki kitne fruits change karne hai, 
                //and stop once fresh is reduced to 0
            }
        }
        int[][] dir={{0,-1},{0,1},{1,0},{-1,0}};
        while(!qu.isEmpty() && fresh>0){
            int size=qu.size();
            minutes++;
            for(int k=0;k<size;k++){ //level
                int[] cur=qu.poll();
                for(int[] d: dir){
                    int x=cur[0]+d[0], y=cur[1]+d[1];
                    if(x>=m || y>=n || x<0 || y<0 || grid[x][y]!=1) continue;
                    grid[x][y]=2;
                    fresh--;
                    qu.offer(new int[]{x,y});
                }
            }
        }
        return fresh==0?minutes:-1;
    }
}