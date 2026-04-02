class Solution {
    private int[] dp;
    private final int mod=(int)1e9+7;
    int countWays(int n, int k) {
        dp=new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n,k);
    }
    private int solve(int n,int k){
        if(n==1) return k;
        if(n==2) return (k+k*(k-1))%mod;
        if(dp[n]!=-1) return dp[n];
        
        //1. last two posts have same color - f(n)=f(n-2)*(k-1)
        int same=(solve(n-2, k)*(k-1))%mod;
        
        //2. last two posts have diff color - f(n)=f(n-1)*(k-1)
        int dif=(solve(n-1,k)*(k-1))%mod;
        
        return dp[n]=(same+dif)%mod;
    }
}
