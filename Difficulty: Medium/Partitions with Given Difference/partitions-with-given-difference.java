class Solution {
    private int total=0;
    private int res=0;
    public int countPartitions(int[] arr, int diff) {
        for(int i:arr) total+=i;
        if(total<diff || (total+diff)%2!=0) return 0;
        int target=(total+diff)/2;
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int num:arr){//knapsack
            for(int t=target;t>=num;t--){
                dp[t]+=dp[t-num];
            }
        }
        return dp[target];
    }
}
