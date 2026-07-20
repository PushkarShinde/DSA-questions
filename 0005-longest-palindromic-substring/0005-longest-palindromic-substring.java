class Solution {
    int[][] dp;
    public String longestPalindrome(String s) {
        int n=s.length();
        int len=0;
        int start=0;
        
        dp=new int[n][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(solve(s, i,j)){
                    if(len<j-i+1){
                        len=j-i+1;
                        start=i;
                    }
                }
            }
        }

        return s.substring(start, start+len);
    }

    private boolean solve(String s, int i, int j){
        if(i>=j) return true;
        if(dp[i][j]!=-1) return dp[i][j]==1;

        boolean res=false;
        if(s.charAt(i)==s.charAt(j)){
            res |=solve(s, i+1, j-1);
        }

        dp[i][j]=(res?1:0);
        return res;
    }
}