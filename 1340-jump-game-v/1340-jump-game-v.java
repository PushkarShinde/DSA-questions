class Solution {
    int[] dp;
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        dp=new int[n];
        int jump=0;
        for(int i=0;i<n;i++){
            jump=Math.max(jump, 1+dfs(arr, d, i));
        }
        return jump;
    }
    private int dfs(int[] a, int d, int i){
        if(dp[i]!=0) return dp[i];
        int n=a.length;
        int jump=0;
        int num=a[i];
        for(int j=i-1;j>=Math.max(0,i-d);j--){
            if(a[j]>=num) break;
            jump=Math.max(jump, 1+dfs(a, d, j));
        }
        for(int j=i+1;j<=Math.min(n-1,i+d);j++){
            if(a[j]>=num) break;
            jump=Math.max(jump, 1+dfs(a, d, j));
        }
        return dp[i]=jump;
    }
}