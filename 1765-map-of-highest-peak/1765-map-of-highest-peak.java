class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;
        int[][] height=new int[m][n];
        boolean[][] visited=new boolean[m][n];
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j]==1){
                    height[i][j]=0;
                    visited[i][j]=true;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
        int currHeight=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int k=0;k<size;k++){
                int[] cell=queue.poll();
                int i=cell[0], j=cell[1];
                for(int[] d:dir){
                    int ni=i+d[0], nj=j+d[1];
                    if(ni>=0 && nj>=0 && ni<m && nj<n && !visited[ni][nj]){
                        height[ni][nj]=height[i][j]+1;
                        visited[ni][nj]=true;
                        queue.offer(new int[]{ni, nj});
                    }
                }
            }
        }
        return height;
    }
}