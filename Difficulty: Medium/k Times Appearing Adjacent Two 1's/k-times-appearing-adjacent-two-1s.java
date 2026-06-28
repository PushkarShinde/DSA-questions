class Solution {
    private long mod=(long)1e9+7;
    private int n;
    int[][][] dp;
    public int countStrings(int n, int k) {
        this.n=n;
        dp=new int[n+1][k+1][2];
        for(int[][] dk:dp){
            for(int[] d:dk){
                Arrays.fill(d,-1);
            }
        }
        
        return (int)((solve(1,k,0)+solve(1,k,1))%mod);
    }
    private long solve(int i, int k, int pre){
        if(i==n){
            return (k==0)?1L:0L;
        }
        
        if(dp[i][k][pre]!=-1) return dp[i][k][pre];
        
        long res=0L;
        res=(res+solve(i+1,k,0))%mod;
        
        if(pre==1){
            if(k>0) res=(res+solve(i+1,k-1,1))%mod;
        }else{
            res=(res+solve(i+1,k,1))%mod;
        }
        
        return dp[i][k][pre]=(int)res;
    }
}