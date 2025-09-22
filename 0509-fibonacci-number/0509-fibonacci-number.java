class Solution {
    //tc: O(2^n)
    // public int fib(int n) {
    //     if(n<=1) return n;
    //     return fib(n-1)+fib(n-2);
    // }
    
    //memoization
    // public int fib(int n) {
    //     int[] memo=new int[n+1];
    //     Arrays.fill(memo,-1);
    //     return solve(n,memo);
    // }
    // private int solve(int n,int[] memo){
    //     if(n<=1) {
    //         memo[n]=n;
    //         return memo[n];
    //     }
    //     if(memo[n]!=-1) return memo[n];
    //     memo[n]=fib(n-1)+fib(n-2);
    //     return memo[n];
    // }

    //BOTTUMN UP
    public int fib(int n) {
        int[] dp=new int[n+1];
        if(n<=1) return n;
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n]; 
    }
}