class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] small=new int[n];
        small[0]=prices[0];
        for(int i=1;i<n;i++){
            small[i]=Math.min(small[i-1], prices[i-1]);
        }
        int profit=0;
        for(int i=n-1;i>=0;i--){
            profit=Math.max(profit, prices[i]-small[i]);
        }
        return profit;
    }
}