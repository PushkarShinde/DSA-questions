class Solution {
    int[][] dp;
    public String longestPalindrome(String s) {
        int n=s.length();
        int length=0;
        int start=0;
        
        // dp=new int[n][n];
        // for(int[] d:dp){
        //     Arrays.fill(d,-1);
        // }

        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         if(solve(s, i,j)){
        //             if(len<j-i+1){
        //                 len=j-i+1;
        //                 start=i;
        //             }
        //         }
        //     }
        // }
        
        int res=0;
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

                if(dp[i][j] && length<j-i+1){
                    length=j-i+1;
                    start=i;
                }
            }
        }

        return s.substring(start, start+length);
    }

    // private boolean solve(String s, int i, int j){
    //     if(i>=j) return true;
    //     if(dp[i][j]!=-1) return dp[i][j]==1;

    //     boolean res=false;
    //     if(s.charAt(i)==s.charAt(j)){
    //         res |=solve(s, i+1, j-1);
    //     }

    //     dp[i][j]=(res?1:0);
    //     return res;
    // }
}