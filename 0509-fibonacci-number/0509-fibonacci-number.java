class Solution {
    //tc: O(2^n)
    // public int fib(int n) {
    //     if(n<=1) return n;
    //     return fib(n-1)+fib(n-2);
    // }
    
    //memoization
    public int fib(int n) {
        int[] memo=new int[n+1];
        return solve(n,memo);
    }
    private int solve(int n,int[] memo){
        if(n<=1) return n;
        if(memo[n]!=0) return memo[n];
        memo[n]=fib(n-1)+fib(n-2);
        return memo[n];
    }
}