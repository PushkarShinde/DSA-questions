class Solution {
    int[][][][] dp;
    private int mod=(int)1e9+7;
    public int numOfWays(int n) {
        dp=new int[n][4][4][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    Arrays.fill(dp[i][j][k],-1);
                }
            }
        }
        return solve(0,n,-1,-1,-1);
    }
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
}