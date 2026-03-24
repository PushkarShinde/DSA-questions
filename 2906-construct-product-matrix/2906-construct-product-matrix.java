class Solution {
    private int mod=12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] p=new int[n][m];
        int[][] pre=new int[n][m];
        int[][] suf=new int[n][m];

        long prefix=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pre[i][j]=(int)prefix;
                prefix=(prefix*grid[i][j])%mod;
            }
        }

        long suffix=1;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                suf[i][j]=(int)suffix;
                suffix=(suffix*grid[i][j])%mod;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                p[i][j]=(int)(((long)pre[i][j]*suf[i][j])%mod);
            }
        }

        return p;
    }
}