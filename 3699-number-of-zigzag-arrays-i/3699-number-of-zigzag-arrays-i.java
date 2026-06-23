class Solution {
    private long[][] dp;
    private long mod=(long)1e9+7;
    public int zigZagArrays(int n, int l, int r) {
        int k=r-l+1;
        // dp[v][0] -> Number of valid sequences ending in value 'v', where the last step was DOWN
        // dp[v][1] -> Number of valid sequences ending in value 'v', where the last step was UP
        dp=new long[k+1][2];
        
        //base case: len=2
        //For an array of length 2, any pair (u, v) where u != v is valid.
        for(int v=1;v<=k;v++){
            dp[v][0]=k-v;// u > v (The step from u to v was DOWN)
            dp[v][1]=v-1;// u < v (The step from u to v was UP)
        }

        for(int i=3;i<=n;i++){
            long[][] ndp=new long[k+1][2];

            long sumDown=0;
            for(int v=1;v<=k;v++){
                ndp[v][1]=sumDown;
                sumDown=(sumDown+dp[v][0])%mod;
            }
            long sumUp=0;
            for(int v=k;v>=1;v--){
                ndp[v][0]=sumUp;
                sumUp=(sumUp+dp[v][1])%mod;
            }

            dp=ndp;
        }

        long total=0;
        for(int v=1;v<=k;v++){
            total=(total+dp[v][0])%mod;
            total=(total+dp[v][1])%mod;
        }

        return (int)total;
    }
}