class Solution {
    int[][] suf;
    long mod=(long)1e9+7;
    
    public int findWays(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        
        //Precompute
        suf= new int[n + 1][m + 1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                suf[i][j]=mat[i][j] 
                        +suf[i + 1][j] 
                        +suf[i][j + 1] 
                        -suf[i + 1][j + 1];
            }
        }
        
        long[][] dp=new long[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(suf[i][j]>0) dp[i][j]=1;
            }
        }
        
        int[][] nextx = new int[n][m];
        for (int j = 0; j < m; j++) {
            nextx[n - 1][j] = n; // Out of bounds
            for (int i = n - 2; i >= 0; i--) {
                nextx[i][j] = (suf[i][j] > suf[i + 1][j]) ? i + 1 : nextx[i + 1][j];
            }
        }

        // next_y[i][j] = first col y > j where suf[i][y] < suf[i][j]
        int[][] nexty = new int[n][m];
        for (int i = 0; i < n; i++) {
            nexty[i][m - 1] = m; // Out of bounds
            for (int j = m - 2; j >= 0; j--) {
                nexty[i][j] = (suf[i][j] > suf[i][j + 1]) ? j + 1 : nexty[i][j + 1];
            }
        }
        
        for(int cut=1;cut<k;cut++){
            long[][] ndp=new long[n][m];
            
            long[][] colSum = new long[n + 1][m + 1];
            long[][] rowSum = new long[n + 1][m + 1];
            
            // Build the running sums of the PREVIOUS DP state
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    colSum[i][j] = (dp[i][j] + colSum[i + 1][j]) % mod;
                    rowSum[i][j] = (dp[i][j] + rowSum[i][j + 1]) % mod;
                }
            }
            
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(suf[i][j]==0) break;
        
                    long res=0;
                    // for(int x=1+i;x<n;x++){
                    //     if(suf[i][j]-suf[x][j]>0){
                    //         res=(res+dp[x][j])%mod;
                    //     }
                    // }
                    
                    // for(int y=1+j;y<m;y++){
                    //     if(suf[i][j]-suf[i][y]>0){
                    //         res=(res+dp[i][y])%mod;
                    //     }
                    // }
                    int nx = nextx[i][j];
                    int ny = nexty[i][j];
                    
                    res = (res + colSum[nx][j]) % mod;
                    res = (res + rowSum[i][ny]) % mod;
                    
                    ndp[i][j]=res;
                }
            }
            
            dp=ndp;
        }
        
        return (int)dp[0][0];
    }
}

