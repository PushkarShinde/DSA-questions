class Solution {
    int[][] dp;
    /**
    At day i, you are in one of two states:
    State 0: not holding stock
    Options:
    Buy → -prices[i] + solve(i+1, 1)
    Skip → solve(i+1, 0)
    State 1: holding stock
    Options:
    Sell → +prices[i] + solve(i+1, 0)
    Hold → solve(i+1, 1)
    That’s it. No magic, no third dimension. */
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(prices, 0,0);
    }
    private int solve(int[] prices, int i, int holding){
        int n=prices.length;
        if(i==n) return 0;
        if(dp[i][holding]!=-1) return dp[i][holding];
        int sell=0;
        int skip=0;
        int buy=0;
        if(holding==0){
            buy=solve(prices, i+1, 1)-prices[i];
            skip=solve(prices, i+1, 0);
        }else{
            sell=solve(prices, i+1, 0)+prices[i];
            skip=solve(prices, i+1, 1);
        }
        int res=Math.max(buy, Math.max(sell,skip));
        return dp[i][holding]=res;
    }
}