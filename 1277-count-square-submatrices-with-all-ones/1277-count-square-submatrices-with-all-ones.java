class Solution {

    private int solve(int i, int j, int[][] matrix, List<List<Integer>> memo){
        int m=matrix.length;
        int n=matrix[0].length;
        int count=0;
        if(memo[i][j]!=-1) return memo[i][j];
        if(i>=m || j>=n) return 0;
        if(matrix[i][j]==0) return 0;
        int right=solve(i, j+1, matrix,memo);
        int diag=solve(i+1, j+1, matrix,memo);
        int left=solve(i+1, j, matrix,memo);
        memo[i][j] = 1 + Math.min(right, Math.min(diag, down));
        return memo[i][j];
    }

    public int countSquares(int[][] matrix) {
        int count=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    count+=solve(i,j,matrix,memo);
                }
            }
        }
        return count;
    }
}