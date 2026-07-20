class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        while(k-->0){
            grid=shift(grid);
        }

        int n=grid.length;
        int m=grid[0].length;
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new ArrayList<>());
            for(int j=0;j<m;j++){
                res.get(i).add(grid[i][j]);
            }
        }
        return res;
    }

    private int[][] shift(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        int[] col=new int[n];

        for(int i=0;i<n;i++){
            col[i]=grid[i][m-1];
        }

        for(int j=m-1;j>=1;j--){
            for(int i=0;i<n;i++){
                grid[i][j]=grid[i][j-1];
            }
        }

        for(int i=1;i<n;i++){
            grid[i][0]=col[i-1];
        }
        grid[0][0]=col[n-1];

        return grid;
    }
}