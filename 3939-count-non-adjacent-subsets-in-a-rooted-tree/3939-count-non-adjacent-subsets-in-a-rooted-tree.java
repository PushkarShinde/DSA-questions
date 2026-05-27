class Solution {
    private final int mod=(int)1e9+7;
    private int[] parent, nums;
    private int k, n;
    private List<Integer>[] adj;

    public int countValidSubsets(int[] parent, int[] nums, int k) {
        n=parent.length;
        adj=new ArrayList[n];
        this.k=k;
        this.nums=nums;
        this.parent=parent;

        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int i=1;i<n;i++){
            int u=parent[i];
            adj[u].add(i);
        }

        long[][] rootDP=solve(0);

        // Count all non-empty subsets with sum % k == 0
        // rootDP[0][0] includes the empty subset (taken=0, rem=0)
        // rootDP[1][0] = subsets where root is taken, sum % k == 0
        long res=(rootDP[0][0] + rootDP[1][0])%mod;

        res=(res-1+mod)%mod;

        return (int)res;
    }

    // result[taken][remainder]
    private long[][] solve(int node){
        int rem=nums[node]%k;

        long[][] dp=new long[2][k];
        dp[1][rem]=1;//take the node
        dp[0][0]=1;// don't take the node

        for(int c: adj[node]){
            long[][] childDP=solve(c);

            long[][] ndp=new long[2][k];
            
            for(int taken=0;taken<2;taken++){
                for(int r=0;r<k;r++){
                    if(dp[taken][r]==0) continue;

                    if(taken==1){// Node is taken
                        // child CANNOT be taken
                        // Only merge childDP[0][*]
                        for(int cr=0;cr<k;cr++){
                            if(childDP[0][cr]==0) continue;
                            int nr=(r+cr)%k;
                            ndp[1][nr]=(ndp[1][nr]+dp[1][r]*childDP[0][cr])%mod;
                        }
                    }else{
                        for(int ctaken=0;ctaken<2;ctaken++){
                            for(int cr=0;cr<k;cr++){
                                if(childDP[ctaken][cr]==0) continue;
                                int nr=(r+cr)%k;
                                ndp[0][nr]=(ndp[0][nr]+dp[0][r]*childDP[ctaken][cr])%mod;
                            }
                        }
                    }
                }
            }
            dp=ndp;
        }
        return dp;
    }
}