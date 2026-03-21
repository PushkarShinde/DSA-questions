class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int side=k-1;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=x;i<Math.min(x+k/2, n);i++){
            for(int j=y;j<Math.min(y+k, m);j++){
                int temp=grid[i][j];
                grid[i][j]=grid[i+side][j];
                grid[i+side][j]=temp;
            }
            side-=2;
        }
        return grid;
    }
}