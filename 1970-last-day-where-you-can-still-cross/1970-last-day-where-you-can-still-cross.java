class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int n=cells.length;
        int day=0;
        int left=1, right=row*col;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(crossed(row, col, cells, mid)){
                day=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return day;
    }
    private boolean crossed(int row, int col, int[][] cells, int day){
        boolean[][] water=new boolean[row][col];
        for(int i=0;i<day;i++){
            int x=cells[i][0]-1;
            int y=cells[i][1]-1;
            water[x][y]=true;
        }
        boolean[][] vis=new boolean[row][col];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<col;i++){
            if(!water[0][i]){
                q.offer(new int[]{0,i});
                vis[0][i]=true;
            }
        }
        int[][] dir={{0,-1},{0,1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x=cur[0], y=cur[1];
            if(x==row-1) return true;
            for(int[] d:dir){
                int xd=x+d[0], yd=y+d[1];
                if(xd<0 || xd>=row || yd<0 || yd>=col || water[xd][yd] || vis[xd][yd]){
                    continue;
                }
                vis[xd][yd]=true;
                q.offer(new int[]{xd,yd});
            }
        }
        return false;
    }
}