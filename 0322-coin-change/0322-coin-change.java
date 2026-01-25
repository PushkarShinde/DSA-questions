class Solution {
    int[][] dp;
    private int inf=(int)1e9;
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        dp=new int[n][amount+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        int ans=solve(coins,amount,0);
        return ans>=inf?-1:ans;
    }
    private int solve(int[] coins, int amount, int i){
        int n=coins.length;
        if(amount==0) return 0;
        if(i>=n) return inf;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int nottake=solve(coins, amount, i+1);
        int take=inf;
        if(coins[i]<=amount){
            take=1+solve(coins, amount-coins[i], i);
        }
        return dp[i][amount]=Math.min(take,nottake);
    }
}