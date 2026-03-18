class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] pre=new int[n][m];
        int count=0;

        pre[0][0]=grid[0][0];
        for(int i=1;i<n;i++){
            pre[i][0]=pre[i-1][0]+grid[i][0];
        }
        for(int j=1;j<m;j++){
            pre[0][j]=pre[0][j-1]+grid[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(i>0 && j>0){
                    pre[i][j]=pre[i-1][j]+pre[i][j-1]+grid[i][j]-pre[i-1][j-1];
                }else if(i==0){
                    pre[i][j]=pre[i][j-1]+grid[i][j];
                }else if(j==0){
                    pre[i][j]=pre[i-1][j]+grid[i][j];
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pre[i][j]<=k) count++;
            }
        }
        return count;
    }
}