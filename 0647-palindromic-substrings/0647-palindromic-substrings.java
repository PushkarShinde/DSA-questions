class Solution {
    int[][] dp;
    public int countSubstrings(String s) {
        int n=s.length();
        dp=new int[n][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(solve(i,j,s)) count++;
            }
        }

        return count;
    }
    private boolean solve(int i, int j, String s){
        if(i>=j) return true;

        if(dp[i][j]!=-1) return dp[i][j]==1;
        boolean res=false;
        if(s.charAt(i)==s.charAt(j)){
            res |= solve(i+1, j-1, s);
        }

        dp[i][j]=res?1:0;

        return res;
    }
}