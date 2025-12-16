class Solution {
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    public int largestIsland(int[][] grid) {
        int id=2;
        int maxSize=0;
        int n=grid.length;
        Map<Integer, Integer> islandSize=new HashMap<>();
        // boolean[][] vis=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int size=dfs(grid, i, j, id);
                    islandSize.put(id, size);
                    maxSize=Math.max(size, maxSize);
                    id++;
                }
            }
        }
        if(maxSize==n*n) return maxSize;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    Set<Integer> neighbor=new HashSet<>();
                    for(int[] d:dir){
                        int x=i+d[0], y=j+d[1];
                        if(x<0 || y<0 || x>=n || y>=n) continue;
                        if(grid[x][y]>1){
                            neighbor.add(grid[x][y]);
                        }
                    }
                    int potential=1;
                    for(int island:neighbor){
                        potential+=islandSize.get(island);
                    }
                    maxSize=Math.max(maxSize, potential);
                }
            }
        }
        return maxSize;
    }
    private int dfs(int[][] grid, int i, int j, int id){
        int n=grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j]=id;
        int size=1;
        size+=dfs(grid, i+1, j, id);
        size+=dfs(grid, i-1, j, id);
        size+=dfs(grid, i, j+1, id);
        size+=dfs(grid, i, j-1, id);
        return size;
    }
}