class Solution {
    // int[][] dp;
    public int countSubstrings(String s) {
        int n=s.length();
        // dp=new int[n][n];
        // for(int[] d:dp){
        //     Arrays.fill(d,-1);
        // }

        // int count=0;
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         if(solve(i,j,s)) count++;
        //     }
        // }

        // return count;

        int count=0;
        boolean[][] dp=new boolean[n][n];
        for(int len=1;len<=n;len++){
            for(int i=0;i+len-1<n;i++){
                int j=i+len-1;

                if(i==j){
                    dp[i][j]=true;
                }else if(i+1==j){
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                }else{
                    dp[i][j]=s.charAt(i)==s.charAt(j) && dp[i+1][j-1];
                }

                if(dp[i][j]) count++;
            }
        }

        return count;
    }
    // private boolean solve(int i, int j, String s){
    //     if(i>=j) return true;

    //     if(dp[i][j]!=-1) return dp[i][j]==1;
    //     boolean res=false;
    //     if(s.charAt(i)==s.charAt(j)){
    //         res |= solve(i+1, j-1, s);
    //     }

    //     dp[i][j]=res?1:0;

    //     return res;
    // }
}