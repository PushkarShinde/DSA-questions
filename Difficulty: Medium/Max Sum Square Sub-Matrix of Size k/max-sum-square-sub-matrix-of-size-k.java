class Solution {
    public int maximumSum(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] pre=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                pre[i][j]=mat[i-1][j-1]+pre[i-1][j]+pre[i][j-1]-pre[i-1][j-1];
            }
        }
        
        int res=Integer.MIN_VALUE;
        for(int i=k;i<=n;i++){
            for(int j=k;j<=m;j++){
                int cur=pre[i][j]-pre[i-k][j]-pre[i][j-k]+pre[i-k][j-k];
                res=Math.max(res, cur);
            }
        }
        
        return res;
    }
}