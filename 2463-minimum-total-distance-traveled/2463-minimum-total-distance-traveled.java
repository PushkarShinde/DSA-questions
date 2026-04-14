class Solution {
    long[][] dp;
    List<Integer> robot; 
    int[][] factory;
    int n;
    int m;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        this.robot=robot;
        this.factory=factory;
        this.n=robot.size();
        this.m=factory.length;
        Arrays.sort(factory, (x,y)->x[0]-y[0]);
        Collections.sort(robot);

        dp=new long[n+1][m+1];//min cost to assign first i robots to first j factories
        for(long[] d:dp){
            Arrays.fill(d,-1);
        }

        return solve(0,0);
    }

    private long solve(int r, int f){
        if(r>=n) return 0;
        if(f>=m) return (long)1e18;

        if(dp[r][f]!=-1) return dp[r][f];

        long res=solve(r,f+1);

        long cost=0;
        for(int i=0;i<factory[f][1] && i+r<n;i++){
            cost+=Math.abs(robot.get(r+i)-factory[f][0]);
            res=Math.min(cost+solve(r+i+1,f+1), res);
        }

        return dp[r][f]=res;
    }
}