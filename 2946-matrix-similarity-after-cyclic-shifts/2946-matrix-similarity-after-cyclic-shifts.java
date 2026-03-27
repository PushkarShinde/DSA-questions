class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        k%=m;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int expected=0;
                if((i&1)==1){
                    expected=mat[i][(j+k)%m];
                }else{
                    expected=mat[i][(j-k+m)%m];
                }
                if(mat[i][j]!=expected) return false;
            }
        }

        return true;
    }
}