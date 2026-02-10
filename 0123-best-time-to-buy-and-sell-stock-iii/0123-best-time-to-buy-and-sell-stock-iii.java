class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(prices, 0,0,0);
    }
    private int solve(int[] prices, int i, int holding, int term){
        int n=prices.length;
        if(i==n) return 0;
        if(dp[i][holding][term]!=-1) return dp[i][holding][term];
        int sell=0;
        int skip=0;
        int buy=0;
        int res=0;
        if(term==0){
            if(holding==0){
                buy=solve(prices, i+1, 1, 0)-prices[i];
                skip=solve(prices, i+1, 0, 0);
            }else{
                sell=solve(prices, i+1, 0, 1)+prices[i];
                skip=solve(prices, i+1, 1, 0);
            }
            res=Math.max(buy, Math.max(sell,skip));
        }else if(term==1){
            if(holding==0){
                buy=solve(prices, i+1, 1, 1)-prices[i];
                skip=solve(prices, i+1, 0, 1);
            }else{
                sell=solve(prices, i+1, 0, 2)+prices[i];
                skip=solve(prices, i+1, 1, 1);
            }
            res=Math.max(buy, Math.max(sell,skip));
        }else{
            return 0;
        }
        return dp[i][holding][term]=res;
    }
}