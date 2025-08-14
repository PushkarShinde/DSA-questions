class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int maxCount=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) {
                    int area=countOnes(grid, i, j);
                    maxCount=Math.max(maxCount, area);
                }
            }
        }
        return maxCount;
    }

    private int countOnes(int[][] grid ,int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return 0;
        }
        if(grid[i][j]==0) return 0;
        grid[i][j]=0;
        int count=1;
        count+=countOnes(grid, i+1, j);
        count+=countOnes(grid, i, j+1);
        count+=countOnes(grid, i-1, j);
        count+=countOnes(grid, i, j-1);

        return count;
    }
}