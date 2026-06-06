class Solution {
    int n;
    String s;
    int mod=(int)1e9+7;
    int[][] dp;
    public int numberOfWays(String corridor) {
        s=corridor;
        n=corridor.length();
        dp=new int[n][3];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }
        return solve(0,0);
    }
    private int solve(int i, int ch){
        if(i==n){
            return (ch==2?1:0);
        }

        if(dp[i][ch]!=-1) return dp[i][ch];

        int res=0;
        if(ch==2){
            if(s.charAt(i)=='S'){//divide karna hi padega
                res=solve(i+1, 1);
            }else{//divide karna option hai
                res=(solve(i+1, 0)+solve(i+1, 2))%mod;
            }
        }else{
            if(s.charAt(i)=='S'){
                res=solve(i+1, ch+1);
            }else{
                res=solve(i+1, ch);
            }
        }

        return dp[i][ch]=res;
    }
}