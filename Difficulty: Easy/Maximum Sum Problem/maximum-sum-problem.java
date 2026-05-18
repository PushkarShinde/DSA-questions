class Solution {
    int[] dp;
    public int maxSum(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }
    
    private int solve(int n){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        
        int sum=solve(n/2)+solve(n/3)+solve(n/4);
        int res=(sum>n)?sum:n;
        
        return dp[n]=res;
    } 
}
