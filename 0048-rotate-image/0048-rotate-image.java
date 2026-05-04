class Solution {
    int n;
    private void swap(int[][] matrix, int i, int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
    private void rev(int[][] matrix, int i){
        for(int j=0;j<n/2;j++){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[i][n-1-j];
            matrix[i][n-1-j]=temp;
        }
    }
    public void rotate(int[][] matrix) {
        this.n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                swap(matrix, i,j);
            }
        }
        for(int i=0;i<n;i++){
            rev(matrix, i);
        }
    }
}