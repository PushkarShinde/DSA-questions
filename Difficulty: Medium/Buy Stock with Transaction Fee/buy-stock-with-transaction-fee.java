class Solution {
    private int[][] dp;
    public int maxProfit(int arr[], int k) {
        int n=arr.length;
        dp=new int[n][2];
        
        for(int[] d:dp) Arrays.fill(d, -1);
        
        return solve(arr, 0, 0, k);
    }
    private int solve(int[] a, int i, int taken, int k){
        int n=a.length;
        if(i==n) return 0;
        if(dp[i][taken]!=-1) return dp[i][taken];
        
        int sell=Integer.MIN_VALUE;
        if(taken==1){
            sell=a[i]-k+solve(a,i+1, 0, k);
        }
        int take=solve(a,i+1,1, k)-a[i];
        int nottake=solve(a,i+1,taken, k);
        
        return dp[i][taken]=Math.max(Math.max(sell, take), nottake);
    }
}