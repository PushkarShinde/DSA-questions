class Solution {

    // private int solve(int i, int j, int[][] matrix, int[][] memo){
    //     int m=matrix.length;
    //     int n=matrix[0].length;
    //     int count=0;
    //     if(i>=m || j>=n) return 0;
    //     if(memo[i][j]!=-1) return memo[i][j];
    //     if(matrix[i][j]==0) return 0;
    //     int right=solve(i, j+1, matrix,memo);
    //     int diag=solve(i+1, j+1, matrix,memo);
    //     int down=solve(i+1, j, matrix,memo);
    //     memo[i][j] = 1 + Math.min(right, Math.min(diag, down));
    //     return memo[i][j];
    // }

    //BOTTUMN UP APPROACH TC- O(N*M)
    public int countSquares(int[][] matrix) {
        int count=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp = new int[m][n];
        // int[][] memo = new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     Arrays.fill(memo[i], -1);
        // }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    // count+=solve(i,j,matrix,memo);
                    if(i==0 || j==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]=1+Math.min(dp[i-1][j],
                                    Math.min(dp[i][j-1],dp[i-1][j-1]));
                    }
                    count+=dp[i][j];
                }
            }
        }
        return count;
    }
}