class Solution {
    int[] a;
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n=nums.length;
        a=new int[n+2];
        a[0]=1; 
        a[n+1]=1; 
        for(int i=1;i<n+1;i++){
            a[i]=nums[i-1];
        }
        dp=new int[n+2][n+2];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }
        return solve(1,n);
    }
    private int solve(int l, int r){
        if(l>r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int res=Integer.MIN_VALUE;
        //imagine we are going from bottom up, kth ballon ke alawa baki sare burst ho chuke h
        for(int k=l;k<=r;k++){
            res=Math.max(res, solve(l, k-1)+solve(k+1,r)+a[l-1]*a[k]*a[r+1]);
        }
        return dp[l][r]=res;
    }

}