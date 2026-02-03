class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(text1, text2,0,0);
    }
    private int solve(String t1, String t2, int i, int j){
        int n=t1.length();
        int m=t2.length();
        if(i==n || j==m) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int count=0;
        if(t1.charAt(i)==t2.charAt(j)) {
            return dp[i][j]=solve(t1, t2, i+1, j+1)+1;
        }
        count=Math.max(count, solve(t1, t2, i, j+1));
        count=Math.max(count, solve(t1, t2, i+1, j));
        return dp[i][j]=count;
    }
}