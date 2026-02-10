class Solution {
    int[][] dp;
    int[] prices;
    int fee;
    public int maxProfit(int[] prices, int fee) {
        this.fee=fee;
        this.prices=prices;
        int n=prices.length;
        dp=new int[n][2];
        for(int[] i:dp){
            Arrays.fill(i, -1);
        }
        return solve(0, 0);
    }
    private int solve(int i, int hold){
        int n=prices.length;
        if(i==n) return 0;
        if(dp[i][hold]!=-1) return dp[i][hold];
        int buy=0;
        int sell=0;
        int skip=0;
        if(hold==0){
            buy=solve(i+1, 1)-prices[i];
            skip=solve(i+1, 0);
        }else {
            sell=solve(i+1, 0)+prices[i]-fee;
            skip=solve(i+1, 1);
        }
        int res=Math.max(buy, Math.max(sell, skip));
        return dp[i][hold]=res;
    }
}