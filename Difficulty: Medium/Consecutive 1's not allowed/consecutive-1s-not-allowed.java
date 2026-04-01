class Solution {
    private int[][] dp;
    int countStrings(int n) {
        dp=new int[n+1][2];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }
        return solve(n,1,0)+solve(n,1,1);
    }
    
    private int solve(int n,int i, int pre){
        if(i==n){
            return 1;
        }
        if(dp[i][pre]!=-1) return dp[i][pre];
        int res=0;
        if(pre==1){
            res+=solve(n,i+1,0);
        }else{
            res+=solve(n,i+1,1);
            res+=solve(n,i+1,0);
        }
        
        return dp[i][pre]=res;
    }
}