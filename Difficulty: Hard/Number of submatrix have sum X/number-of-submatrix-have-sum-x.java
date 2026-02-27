class Solution {
    public int countSquare(int[][] mat, int x) {
        int n=mat.length;
        int m=mat[0].length;
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int side=1;
                while(side+i-1<n && side+j-1<m){
                    int sum=0;
                    for(int l=i;l<side+i;l++){
                        for(int r=j;r<side+j;r++){
                            sum+=mat[l][r];
                        }
                    }
                    if(sum==x) res++;
                    side++;
                }
            }
        }
        return res;
    }
}