class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] high=new int[n];
        int[] low=new int[n];
        low[0]=prices[0];
        for(int i=1;i<n;i++){
            low[i]=Math.min(low[i-1], prices[i]);
        }
        high[n-1]=prices[n-1];
        for(int i=n-2;i>=0;i--){
            high[i]=Math.max(high[i+1], prices[i]);
        }
        int maxProfit=0;
        for(int i=0;i<n;i++){
            maxProfit=Math.max(maxProfit, high[i]-low[i]);
        }
        return maxProfit;
    }
}