class Solution {
    int[] dp;
    public int numTrees(int n) {
        dp=new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n);
    }
    private int solve(int n){
        if(n<=1) return 1;
        if(dp[n]!=-1) return dp[n];
        int res=0;
        for(int node=1;node<=n;node++){
            res+=solve(node-1)*solve(n-node);
        }
        return dp[n]=res;
    }
}