class Solution {
    public static int countWays(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        long mod=(long)1e9+7;
        long[][] dp=new long[n+1][m+1];
        
        if(n<m) return 0;
        
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%mod;//select or ignore
                }else{
                    dp[i][j]=dp[i-1][j];//ignore
                }
            }
        }
        
        return (int)(dp[n][m]%mod);
    }
}
