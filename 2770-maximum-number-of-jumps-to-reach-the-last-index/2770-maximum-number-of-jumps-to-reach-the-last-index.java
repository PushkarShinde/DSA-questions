class Solution {
    int[] dp;
    public int maximumJumps(int[] nums, int target) {
        int n=nums.length;
        dp=new int[n];
        Arrays.fill(dp, -1);

        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            int a=nums[i];
            for(int j=i+1;j<n;j++){
                int b=nums[j];
                if(Math.abs(a-b)<=target) adj[i].add(j);
            }
        }

        int res=solve(adj, 0, nums);
        return (res<0?-1:res);
    }
    private int solve(List<Integer>[] adj, int i, int[] a){
        if(i==a.length-1) return 0;
        if(dp[i]!=-1) return dp[i];
        int res=Integer.MIN_VALUE;
        for(int j:adj[i]){
            res=Math.max(1+solve(adj, j,a), res);
        }
        return dp[i]=res;
    }
}