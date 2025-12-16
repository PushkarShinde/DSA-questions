class Solution {
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        boolean[][] vis=new boolean[n][n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,grid[0][0]});
        int maxElevation=0;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int i=cur[0], j=cur[1], elevation=cur[2];
            if(vis[i][j]) continue;
            vis[i][j]=true;
            maxElevation=Math.max(maxElevation, elevation);
            if(i==n-1 && j==n-1) return maxElevation;
            for(int[] di:dir){
                int x=i+di[0], y=j+di[1];
                if(x<0 || y<0 || x>=n || y>=n || vis[x][y]) continue;
                pq.offer(new int[]{x,y,grid[x][y]});
            }
        }
        return maxElevation;
    }
}