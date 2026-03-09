class Solution {
    private int limit;
    private int mod=(int)1e9+7;
    int[][][] dp;
    public int numberOfStableArrays(int zero, int one, int limit) {
        this.limit=limit;
        dp=new int[zero+1][one+1][2];
        for(int i=0;i<=zero;i++){
            for(int j=0;j<=one;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        /*
        TABULATION 

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
        */
        return (solve(zero, one, true)+solve(zero, one, false))%mod;
    }

    private int solve(int leftZero, int leftOne, boolean one){
        if(leftZero==0 && leftOne==0) return 1;

        if(dp[leftZero][leftOne][one?1:0]!=-1) return dp[leftZero][leftOne][one?1:0];

        int res=0;
        if(one){//iske pehle one liya tha
            for(int i=1;i<=Math.min(leftZero,limit);i++){
                res=(res+solve(leftZero-i, leftOne, false))%mod;
            }
        }
        if(!one){//iske pehle one liya tha
            for(int i=1;i<=Math.min(leftOne,limit);i++){
                res=(res+solve(leftZero, leftOne-i, true))%mod;
            }
        }
        return dp[leftZero][leftOne][one?1:0]=res%mod;
    }
}