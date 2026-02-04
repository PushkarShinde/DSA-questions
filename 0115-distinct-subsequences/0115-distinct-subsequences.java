class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        dp=new int[n+1][m+1];
        for(int[] i:dp){
            Arrays.fill(i, -1);
        }
        if(n<m) return 0;
        return solve(s, t, n,m );
    }
    private int solve(String s, String t, int i, int j){
        if(j==0) return 1;
        if(i==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j]=solve(s,t,i-1,j-1)+solve(s,t,i-1,j);
        }else{
            return dp[i][j]=solve(s,t,i-1,j);
        }
    }
}