class Solution {
    int[][] dir={{-1,0},{-1,-1},{-1,1}, {0,-1}, {0,1},{1,-1},{1,1}, {1,0}};
    class Cell{
        int x, y, dist;
        Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1; 

        int[][] dist=new int[n][n];
        for(int[] d: dist)Arrays.fill(d, Integer.MAX_VALUE);
        PriorityQueue<Cell> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.offer(new Cell(0,0,1));
        dist[0][0]=1;
        while(!pq.isEmpty()){
            Cell cur=pq.poll();
            int i=cur.x, j=cur.y, distance=cur.dist;
            if(i==n-1 && j==n-1) return distance;
            for(int[] d: dir){
                int x=i+d[0], y=j+d[1];
                if(x<0 || y<0 || x>=n || y>=n || grid[x][y]!=0 || dist[x][y]<=distance+1){
                    continue;
                }
                dist[x][y]=distance+1;
                pq.offer(new Cell(x,y,distance+1));
            }
        }
        return -1;

        /*
        NORMAL BFS

        int n=grid.length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1; 
        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][n];
        q.offer(new int[]{0,0, 1});
        vis[0][0]=true;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int i=cur[0], j=cur[1], dist=cur[2];
            if(i==n-1 && j==n-1) return dist;
            for(int[] d: dir){
                int x=i+d[0], y=j+d[1];
                if(x<0 || y<0 || x>=n || y>=n || grid[x][y]!=0 || vis[x][y]){
                    continue;
                }
                vis[x][y]=true;
                q.offer(new int[]{x,y, dist+1});
            }
        }
        return -1;
        */
    }
}