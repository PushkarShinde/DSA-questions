class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        if(n==1 && mat[0][0]!=target[0][0]) return false;

        boolean zero=true;
        outer: for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num=mat[i][j];
                int targetNum=target[i][j];
                if(num!=targetNum){
                    zero=false;
                    break outer;
                }
            }
        }
        if(zero) return true;

        boolean ninety=true;
        outer: for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num=mat[i][j];
                int targetNum=target[j][n-1-i];
                if(num!=targetNum){
                    ninety=false;
                    break outer;
                }
            }
        }
        if(ninety) return true;

        boolean oneeighty=true;
        outer: for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num=mat[i][j];
                int targetNum=target[n-1-i][n-1-j];
                if(num!=targetNum){
                    oneeighty=false;
                    break outer;
                }
            }
        }
        if(oneeighty) return true;

        boolean twoseventy=true;
        outer: for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num=mat[i][j];
                int targetNum=target[n-1-j][i];
                if(num!=targetNum){
                    twoseventy=false;
                    break outer;
                }
            }
        }
        if(twoseventy) return true;

        return false;
    }
}