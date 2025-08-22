class Solution {

    public int minimumArea(int[][] grid) {
        int minRow=Integer.MAX_VALUE;
        int maxRow=Integer.MIN_VALUE;
        int minCol=Integer.MAX_VALUE;
        int maxCol=Integer.MIN_VALUE;
        int row=grid.length;
        int col=grid[0].length;
        int r=0, l=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    minCol=Math.min(minCol, j);
                    maxCol=Math.max(maxCol, j);
                    minRow=Math.min(minRow, i);
                    maxRow=Math.max(maxRow, i);
                }
            }
        }
        return (maxCol-minCol+1)*(maxRow-minRow+1);
    }
}