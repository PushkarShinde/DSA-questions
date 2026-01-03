class Solution {
    private int mod=(int)1e9+7;
    /*
    int[][][][] dp;
    private int solve(int i, int n, int pre1, int pre2, int pre3){
        if(i==n){
            return 1;
        }
        if(dp[i][pre1+1][pre2+1][pre3+1]!=-1) return dp[i][pre1+1][pre2+1][pre3+1];
        int total=0;
        for(int c1=0;c1<3;c1++){
            for(int c2=0;c2<3;c2++){
                for(int c3=0;c3<3;c3++){
                    if(c1!=c2 && c2!=c3 && pre1!=c1 && pre2!=c2 && pre3!=c3)
                        total=(total+solve(i+1,n,c1, c2, c3))%mod;
                }
            }
        }
        return dp[i][pre1+1][pre2+1][pre3+1]=total;
    }
    */
    public int numOfWays(int n) {
        /*
        dp=new int[n][4][4][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    Arrays.fill(dp[i][j][k],-1);
                }
            }
        }
        return solve(0,n,-1,-1,-1);
        */
        long a=6;//ABA
        long b=6;//ABC
        for(int i=1;i<n;i++){
            long na=(3*a+2*b)%mod;
            long nb=(2*a+2*b)%mod;
            a=na;
            b=nb;
        }
        return (int)((a+b)%mod);
    }
}
/*
For an ABA row:
    It can become 3 ABA
    Or 2 ABC

For an ABC row:
    It can become 2 ABA
    Or 2 ABC
 */