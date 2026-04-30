class Solution {
    int n;
    int m;
    int maxScore;
    int[][][] dp;
    public int maxPathScore(int[][] grid, int k) {
        n=grid.length;
        m=grid[0].length;
        
        dp=new int[n][m][k+1];
        for(int[][] d:dp){
            for(int[] dpr:d){
                Arrays.fill(dpr, -2);
            }
        }
        
        int res=solve(grid, 0,0,k);
        return res!=Integer.MIN_VALUE?res:-1;
    }

    int[][] dir={{1,0},{0,1}};
    private int solve(int[][] grid, int i, int j, int k){
        if(i>=n || j>=m || k<0) return Integer.MIN_VALUE;
        int cur=grid[i][j];
        int cost=(cur==0?0:1);

        if(dp[i][j][k]!=-2) return dp[i][j][k];

        if(i==n-1 && j==m-1) {
            if(k-cost>=0){
                return dp[i][j][k]=cur;
            }else if(cur==0){
                return dp[i][j][k]=0;
            }
            return dp[i][j][k]=Integer.MIN_VALUE;
        }

        int right=solve(grid, i, j+1,k-cost);
        int left=solve(grid, i+1, j,k-cost);
        int best=Math.max(left, right);

        if(best!=Integer.MIN_VALUE) best+=cur;

        return dp[i][j][k]=best;
    }
}