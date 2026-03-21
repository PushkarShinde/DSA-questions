class Solution {
    // int[] dp=new int[n+1];
    public int numTrees(int n) {
        if(n<=1) return 1;

        int res=0;
        for(int node=1;node<=n;node++){
            res+=numTrees(node-1)*numTrees(n-node);
        }
        return res;
    }
}