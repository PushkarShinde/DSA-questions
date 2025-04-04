class Solution {
    private void swap(int[][] arr, int i, int j){
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
    private void reverse(int[] arr, int l, int r){
        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++; r--; 
        }
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
/*      
        BRUTE FORCE
        TC - O(N^2) SC- O(N^2) 
        int[][] arr=new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[j][(n-1)-i]=matrix[i][j]; // wow
            }
        }
*/
        // OPTIMAL
        // 1. We will transpose the matrix
        // 2. We will now reverse each row of the transposed matrix
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                swap(matrix,i,j); // wow
            }
        }
        for(int i=0;i<n;i++){
            reverse(matrix[i],0,n-1); // wow
        }
    }
}