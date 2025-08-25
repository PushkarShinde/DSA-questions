class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        int row=0, col=0, dir = 1; // dir=1 → up-right, dir=-1 → down-left;
        int[] res=new int[n*m];
        for(int i=0; i<m*n; i++){
            res[i] = mat[row][col];
            if(dir==1){// dir=1 → up-right
                if(col==n-1){
                    row++;
                    dir=-1;
                }else if(row==0){
                    col++;
                    dir=-1;
                }else{
                    col++;
                    row--;
                }
            }else{
                if(row==m-1){
                    col++;
                    dir=1;
                }else if(col==0){
                    row++;
                    dir=1;
                }else{
                    col--;
                    row++;
                }
            }
        }
        return res;
    }
}