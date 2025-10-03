class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m=heightMap.length;
        int n=heightMap[0].length;
        PriorityQueue<int[]> boundary=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        boolean[][] visited=new boolean[m][n];
        for(int row=0;row<m;row++){
            boundary.offer(new int[]{heightMap[row][0], row,0});
            visited[row][0]=true;

            boundary.offer(new int[]{heightMap[row][n-1], row,n-1});
            visited[row][n-1]=true;
        }
        for(int col=0;col<n;col++){
            boundary.offer(new int[]{heightMap[0][col], 0, col});
            visited[0][col]=true;

            boundary.offer(new int[]{heightMap[m-1][col], m-1, col});
            visited[m-1][col]=true;
        }

        int water=0;
        int[][] dir=new int[][]{{0,-1}, {0,1}, {1,0}, {-1,0}};

        while(!boundary.isEmpty()){
            int[] cell=boundary.poll();
            int ht=cell[0];
            int i=cell[1];
            int j=cell[2];

            for(int[] d: dir){
                int ii=i+d[0];
                int jj=j+d[1];
                if(ii>0 && ii<m-1 && jj>0 && jj<n-1 && !visited[ii][jj]){
                    water+=Math.max(ht-heightMap[ii][jj],0);
                    boundary.offer(new int[]{Math.max(ht, heightMap[ii][jj]), ii, jj});
                    visited[ii][jj]=true;
                }
            }
        }
        return water;
    }
}