class Solution {
    int[][][] dp;
    int[] prices;
    public int maxProfit(int k, int[] prices) {
        this.prices=prices;
        int n=prices.length;
        dp=new int[n+1][2][k+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0,0,k);
    }
    private int solve(int i, int hold, int k){
        int n=prices.length;
        if(i>=n || k==0) return 0;
        if(dp[i][hold][k]!=-1) return dp[i][hold][k];
        int res=0;
        int buy=0;
        int sell=0;
        int skip=0;
        if(hold==0){
            buy=solve(i+1, 1,k)-prices[i];
            skip=solve(i+1, 0, k);
        }else{
            sell=prices[i]+solve(i+1, 0,k-1);
            skip=solve(i+1, 1, k);
        }
        res=Math.max(buy, Math.max(sell, skip));
        return dp[i][hold][k]=res;
    }
}