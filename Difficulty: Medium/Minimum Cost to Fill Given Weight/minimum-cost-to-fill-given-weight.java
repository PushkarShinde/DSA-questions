class Solution {
    public int minimumCost(int[] cost, int W) {
        int n=cost.length;
        // dp[i]=minimum cost to buy exactly i kg of oranges
        int[] dp=new int[W+1];
        int inf=Integer.MAX_VALUE;
        Arrays.fill(dp,inf);
        dp[0]=0;

        for(int i=0;i<n;i++){
            int weight=i+1;
            int price=cost[i];
            if(price==-1) continue;
            
            for(int j=weight;j<=W;j++){
                if(dp[j-weight]!=inf){
                    dp[j]=Math.min(dp[j],dp[j-weight]+price);
                }    
            }
        }
        
        return dp[W]==inf?-1:dp[W];
    }
}