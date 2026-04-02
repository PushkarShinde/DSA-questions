class Solution {
    int[][][] dp;
    int n;
    int m;
    public int maximumAmount(int[][] coins) {
        this.n=coins.length;
        this.m=coins[0].length;
        dp=new int[n][m][3];
        for(int[][] x:dp){
            for(int[] y: x){
                Arrays.fill(y,Integer.MIN_VALUE);
            }
        }
        return solve(coins, 0,0,2);
    }
    private int[][] dir={{1,0},{0,1}};
    private int solve(int[][] coins, int i, int j, int neut){
        if(i==n-1 && j==m-1){
            if(coins[i][j]<0 && neut>0) return 0;
            return coins[i][j];
        }
        if(dp[i][j][neut]!=Integer.MIN_VALUE) return dp[i][j][neut];

        int res=Integer.MIN_VALUE;

        for(int[] d:dir){
            int nx=i+d[0];
            int ny=j+d[1];
            if(nx>=n || ny>=m) continue;
            if(coins[i][j]<0 && neut>0){
                res=Math.max(res, solve(coins, nx,ny,neut-1));
            }
            res=Math.max(res, coins[i][j]+solve(coins, nx,ny,neut));
        }
        return dp[i][j][neut]=res;
    }
}