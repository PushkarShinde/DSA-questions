class Solution {
    public int countWays(int n, int m) {
        if(n<m) return 1;
        
        long mod=(long)1e9+7;
        long[] dp=new long[n+1];
        
        for(int i=0;i<=n;i++){
            if(i<m){
                dp[i]=1;
            }else{
                dp[i]=(dp[i-1]+dp[i-m])%mod;
            }
        }
        return (int)dp[n];
    }
}