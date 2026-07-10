class Solution {
    int[][] dp;
    int n;
    int[] stones;
    Map<Integer, Integer> map;
    public boolean canCross(int[] stones) {
        if(stones[1]!=1) return false;
        
        this.stones=stones;
        n=stones.length;
        dp=new int[n+1][n+1];
        for(int[] d:dp){
            Arrays.fill(d, -1);
        }

        map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(stones[i], i);
        }

        return solve(1,1);
    }

    private boolean solve(int i, int k){
        if(i==n-1) return true;

        if(dp[i][k]!=-1) return dp[i][k]==1;

        int s=stones[i];
        boolean res=false;
        for(int j=-1;j<2;j++){
            int jump=k+j;
            if(jump>0){
                int next=s+jump;
                if(map.containsKey(next)){
                    int nextInd=map.get(next);
                    if(solve(nextInd, jump)){
                        res=true;
                        break;
                    }
                }
            }
        }

        dp[i][k]=res?1:0;
        return res;
    }
}