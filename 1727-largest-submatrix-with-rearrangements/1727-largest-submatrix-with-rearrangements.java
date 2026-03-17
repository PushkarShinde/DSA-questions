class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int res=0;
        int[][] grid=new int[n][m];
        for(int i=0;i<n;i++){
            if(i>0){
                for(int j=0;j<m;j++){
                    if(matrix[i-1][j]==1 && matrix[i][j]==1){
                        grid[i][j]=grid[i-1][j]+matrix[i][j];
                    }else{
                        grid[i][j]=matrix[i][j];
                    }
                }
            }else{
                for(int j=0;j<m;j++){
                    grid[i][j]=matrix[i][j];
                }
            }

            int[] row=grid[i].clone();
            Arrays.sort(row);
            int ht=Integer.MAX_VALUE;
            int base=1;
            for(int j=m-1;j>=0;j--){
                ht=Math.min(ht, row[j]);
                res=Math.max(res, ht*base);
                base++;
            }
        }
        return res;
    }
}