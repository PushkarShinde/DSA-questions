class Solution {
    public int countSpanTree(int n, int[][] edges) {
        if(n==1) return 1;
        int[][] lap=new int[n][n];
        for(int[] e:edges){
            lap[e[1]][e[1]]++;
            lap[e[0]][e[0]]++;
            
            lap[e[1]][e[0]]--;
            lap[e[0]][e[1]]--;
        }

        int[][] cofactor=new int[n-1][n-1];
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                cofactor[i-1][j-1]=lap[i][j];
            }
        }
        
        return determinant(cofactor);
    }
    
    private int determinant(int[][] matrix){
        int n=matrix.length;
        if(n==0) return 1;
        
        double[][] mat=new double[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j]=matrix[i][j];
            }
        }
        
        double det=1.0;
        
        //Gaussian elimination to convert to upper triangular form
        for(int i=0;i<n;i++){
            int pivot=i;
            for(int j=i+1;j<n;j++){
                if(Math.abs(mat[j][i])>Math.abs(mat[pivot][i])){
                    pivot=j;
                }
            }
            
            // Using a small epsilon to check for 0.0
            if (Math.abs(mat[pivot][i]) < 1e-9) return 0;
            
            if(pivot!=i){
                double[] temp=mat[i];
                mat[i]=mat[pivot];
                mat[pivot]=temp;
                det=-det;
            }
            
            for(int j=i+1;j<n;j++){
                double fact=mat[j][i]/mat[i][i];
                for(int k=i;k<n;k++){
                    mat[j][k]-=fact*mat[i][k];
                }
            }
            
            det*=mat[i][i];
        }
        return (int)Math.round(Math.abs(det));
    }
}