class Solution {
    // int[][] dir={{1,1},{1,0},{1,-1}};
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int minAbove=dp[i-1][j];
                if(j!=0)minAbove=Math.min(minAbove,dp[i-1][j-1]);
                if(j!=n-1)minAbove=Math.min(minAbove,dp[i-1][j+1]);
                dp[i][j]=minAbove+matrix[i][j];
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            res=Math.min(res,dp[n-1][i]);
        }
        return res;
    }
    /*
    private int solve(int[][] matrix,int row, int col){
        int n=matrix.length;
        if(row==n-1){
            return matrix[row][col];
        }
        if(dp[row][col]!=-1) return dp[row][col];
        int total=matrix[row][col];
        int num=Integer.MAX_VALUE;
        for(int[] d:dir){
            int x=row+d[0];
            int y=col+d[1];
            if(x<0 || y<0 || x>=n || y>=n) continue;
            num=Math.min(num,solve(matrix,x,y));
        }
        total+=num;
        return dp[row][col]=total;
    }
    */
}