class Solution {
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(arr, k, 0);
    }
    private int solve(int[] a, int k, int i){
        int n=a.length;
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int max=Integer.MIN_VALUE;
        int res=0;
        for(int j=i;j<n && j-i+1<=k;j++){
            max=Math.max(max, a[j]);
            res=Math.max(res, solve(a,k,j+1)+max*(j-i+1));
        }
        return dp[i]=res;
    }
}