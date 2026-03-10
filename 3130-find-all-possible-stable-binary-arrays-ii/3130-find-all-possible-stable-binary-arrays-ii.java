class Solution {
    private int limit;
    private int mod=(int)1e9+7;
    private int[][][] dp;
    public int numberOfStableArrays(int zero, int one, int limit) {
        this.limit=limit;
        dp=new int[zero+1][one+1][2];
        for(int i=0;i<=Math.min(limit, zero);i++) dp[i][0][0]=1;
        for(int i=0;i<=Math.min(limit, one);i++) dp[0][i][1]=1;

        for(int i=1;i<=zero;i++){
            for(int j=1;j<=one;j++){
                if(i>limit){
                    dp[i][j][0]=(dp[i-1][j][0]+dp[i-1][j][1]- 
                                dp[i-limit-1][j][1])%mod;
                }else{
                    dp[i][j][0]=(dp[i-1][j][0]+dp[i-1][j][1])%mod;
                }
                dp[i][j][0]=((dp[i][j][0]%mod)+mod)%mod;

                if(j>limit){
                    dp[i][j][1]=(dp[i][j-1][0]+dp[i][j-1][1]- 
                                dp[i][j-limit-1][0])%mod;
                }else{
                    dp[i][j][1]=(dp[i][j-1][0]+dp[i][j-1][1])%mod;
                }
                dp[i][j][1]=((dp[i][j][1]%mod)+mod)%mod;
            }
        }
        return (int)((dp[zero][one][1]+dp[zero][one][0])%mod);
    }
/*
--------------------------------------------------------------------------------
    private int solve(int zero, int one,int end){
        if(zero==0 && one==0) return 1;
        if(zero<0 || one<0) return 0;
        if(dp[zero][one][end]!=-1) return dp[zero][one][end];

        int res=0;
        if(end==1){
            for(int i=1;i<=Math.min(zero, limit);i++){
                res=(res+solve(zero-i, one, 0))%mod;
            }
        }else{
            for(int i=1;i<=Math.min(one, limit);i++){
                res=(res+solve(zero, one-i, 1))%mod;
            }
        }
        return dp[zero][one][end]=res;
    }
    */
}