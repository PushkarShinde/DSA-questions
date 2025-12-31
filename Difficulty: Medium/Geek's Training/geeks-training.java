// User function Template for Java

class Solution {
    /*
    The key is: your state depends on two parameters:
        n — the current day (or index in the array)
        state — the action you cannot take on this day
    So your memoization array should be 2D, not 1D. 
    Right now you have dp=new int[n], which can only store information for one parameter. 
    You need dp[n][state] to store results for every day and every state.
    */
    private int[][] dp;
    public int maximumPoints(int a[][]) {
        int n=a.length;
        dp=new int[n][4];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(a,n-1, 0);
    }
    private int solve(int a[][],int n, int state){
        if(n<0) return 0;
        if (dp[n][state]!=-1) return dp[n][state];
        int run=0, fight=0, learn=0; 
        if(state!=1) run=a[n][0]+solve(a,n-1,1);
        if(state!=2) fight=a[n][1]+solve(a,n-1,2);
        if(state!=3) learn=a[n][2]+solve(a,n-1,3);
        return dp[n][state]=Math.max(run, Math.max(fight,learn));
    } 
}