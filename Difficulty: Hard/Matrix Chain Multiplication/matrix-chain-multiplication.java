class Solution {
    static int[][] dp;
    static int matrixMultiplication(int arr[]) {
        // int n=arr.length;
        // int res=0;
        // int[][] dp=new int[n+1][n+1];
        // for(int len=2;len<n;len++){
        //     for(int i=0;i<n-len;i++){
        //         int j=i+len-1;
        //         for(int k=i+1;k<j;k++){
        //             dp[i][j]=dp[i][k]+dp[k+1][j]+arr[i]*arr[k]*arr[j];
        //         }
        //     }
        // }
        // return dp[n][n];
        int n=arr.length;
        dp=new int[n+1][n+1];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }
        return solve(arr, 1, n-1);
    }
    private static int solve(int[] a, int l, int r){
        if(l>=r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int mass=(int)1e9;
        for(int k=l;k<r;k++){
            mass=Math.min(mass, solve(a, l,k)+solve(a, k+1, r)+a[l-1]*a[k]*a[r]);
        }
        return dp[l][r]=mass;
    }
}