class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] res=new int[n-k+1][m-k+1];

        for(int i=0;i<=n-k;i++){
            for(int j=0;j<=m-k;j++){
                int minDif=Integer.MAX_VALUE;
                Set<Integer> set=new HashSet<>();
                for(int x=i;x<i+k;x++){
                    for(int y=j;y<j+k;y++){
                        set.add(grid[x][y]);
                    }
                }
                for(int x:set){
                    for(int y:set){
                        if(x!=y){
                            minDif=Math.min(minDif, Math.abs(x-y));
                        }
                    }
                }

                res[i][j]=minDif==Integer.MAX_VALUE?0:minDif;
            }
        }
        return res;
    }
}