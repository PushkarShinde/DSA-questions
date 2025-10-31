class Solution {
    int[][] dir={{-1,0}, {0,-1}, {0,1}, {1,0}};
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] effort=new int[n][m];
        for(int[] r: effort){
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        effort[0][0]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0,0,0});//x,y,effort
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int i=cur[0], j=cur[1], cf=cur[2];
            if(i==n-1 && j==m-1) return cf;
            if(cf>effort[i][j]) continue;//natkhat mil chuka hai
            for(int d[]: dir){
                int x=i+d[0], y=j+d[1];
                if(x<0 || y<0 || x>=n || y>=m) continue;
                int eff=Math.abs(heights[i][j]-heights[x][y]);
                int newEffort=Math.max(cf, eff);//Maximum effort along the path
                if(newEffort<effort[x][y]){
                    effort[x][y]=newEffort;
                    pq.offer(new int[]{x,y,newEffort});
                }
            }
        }
        return effort[n-1][m-1];
    }
}