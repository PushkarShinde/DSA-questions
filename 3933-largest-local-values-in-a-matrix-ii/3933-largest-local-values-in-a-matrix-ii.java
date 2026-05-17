class Solution {
    public int countLocalMaximums(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int res=0;

        int[] log=new int[m+1];
        for(int i=2;i<=m;i++){
            log[i]=log[i/2]+1;
        }

        //Building row wise sparse tree
        //sparse[i][j][k]=max in row i from col j to col j+2^k-1
        int maxLog=log[m]+1;
        int[][][] st=new int[n][m][maxLog];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                st[i][j][0]=matrix[i][j];
            }
            for(int k=1;k<maxLog;k++){
                int len=1<<k;
                for(int j=0; j+len<=m; j++){
                    st[i][j][k]=Math.max(st[i][j][k-1], st[i][j+(1<<(k-1))][k-1]);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int num=matrix[i][j];
                if(num==0) continue;

                boolean isMax=true;

                int xs=Math.max(0,i-num);
                int xe=Math.min(n-1,i+num);
                for(int x=xs; x<=xe; x++){
                    int ys=Math.max(0,j-num);
                    int ye=Math.min(m-1,j+num);

                    //Ignore the corners where the x and y distance is same
                    if(Math.abs(x-i)==num){
                        if(ys==j-num) ys++;
                        if(ye==j+num) ye--;
                    }

                    if(ys<=ye){
                        int k=log[ye-ys+1];
                        int maxInRow=Math.max(st[x][ys][k], st[x][ye-(1<<k)+1][k]);

                        if(maxInRow>num){
                            isMax=false;
                            break;
                        }
                    }
                    if(!isMax) break;
                }
                if(isMax) res++;
            }
        }
        return res;
    }
}