class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row=matrix.length;
        int c=matrix[0].length;
        int[][] mat=new int[row][c];
        for(int j=0;j<c;j++){
            for(int i=0;i<row;i++){
                if(matrix[i][j]=='0') mat[i][j]=0;
                else{
                    mat[i][j]=(i>0)?mat[i-1][j]+1:1;
                }
            }
        }
        int res=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<c;j++){
                int l=j, r=j;
                while(l>=0 && mat[i][l]>=mat[i][j]) l--;
                while(r<c && mat[i][r]>=mat[i][j]) r++;
                res=Math.max(res, (r-l-1)*mat[i][j]);
            }
        }
        return res;
    }
}