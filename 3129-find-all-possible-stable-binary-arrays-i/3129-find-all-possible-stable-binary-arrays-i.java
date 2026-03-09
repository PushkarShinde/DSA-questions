class Solution {
    private int mod=(int)1e9+7;
    public int numberOfStableArrays(int zero, int one, int limit) {
        long[][][] dp=new long[zero+1][one+1][2];
        for(int k=0;k<=Math.min(zero,limit);k++){
            dp[k][0][0]=1;
        }
        for(int k=0;k<=Math.min(one,limit);k++){
            dp[0][k][1]=1;
        }

        for(int i=1;i<=zero;i++){
            for(int j=1;j<=one;j++){
                if(i>limit){
                    dp[i][j][0]=dp[i-1][j][0]+dp[i-1][j][1]-
                                dp[i-limit-1][j][1];
                }else{
                    dp[i][j][0]=dp[i-1][j][0]+dp[i-1][j][1];
                }
                dp[i][j][0]=((dp[i][j][0]%mod)+mod)%mod;

                if(j>limit){
                    dp[i][j][1]=dp[i][j-1][0]+dp[i][j-1][1]-
                                dp[i][j-limit-1][0];
                }else{
                    dp[i][j][1]=dp[i][j-1][0]+dp[i][j-1][1];
                }
                dp[i][j][1]=((dp[i][j][1]%mod)+mod)%mod;
            }
        }
        return (int)((dp[zero][one][1]+dp[zero][one][0])%mod);
    }
}