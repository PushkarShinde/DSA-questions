class Solution {
    int[][] dp;
    public int minDistance(String w1, String w2) {
        int n=w1.length();
        int m=w2.length();
        dp=new int[n+1][m+1];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return solve(w1,w2,n,m);
    }
    private int solve(String w1, String w2, int i,int j){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(w1.charAt(i-1)==w2.charAt(j-1)){
            return dp[i][j]=solve(w1,w2,i-1,j-1);
        }
        return dp[i][j]=1+Math.min(solve(w1,w2,i-1,j),//we deleted the char at i 
            Math.min(solve(w1,w2,i-1,j-1),//replaced the char with desired char
                solve(w1,w2,i,j-1)));//we inserted a desired char at i+1
    }
}