class Solution {
    private int mod=(int)1e9+7;
    public int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();
        int[][] dp=new int[n+1][n+1];//max score from (n-1,n-1) to (i,j);
        int[][] paths=new int[n+1][n+1];//number of paths from (n-1,n-1) to (i,j);

        for(int[] d:dp){
            Arrays.fill(d, -1);
        }

        dp[n-1][n-1]=0;
        paths[n-1][n-1]=1;

        int[][] dir={{0,-1},{-1,0},{-1,-1}};

        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(dp[i][j]==-1) continue;

                for(int[] d:dir){
                    int nx=i+d[0];
                    int ny=j+d[1];

                    if(nx<0 || ny<0 || board.get(nx).charAt(ny)=='X') continue;

                    char c=board.get(nx).charAt(ny);
                    int val=(c=='E')?0:c-'0';

                    if(dp[nx][ny]<dp[i][j]+val){
                        dp[nx][ny]=dp[i][j]+val;
                        paths[nx][ny]=paths[i][j];
                    }else if(dp[nx][ny]==dp[i][j]+val){
                        paths[nx][ny]=(paths[nx][ny]+paths[i][j])%mod;
                    }
                }
            }
        }

        return dp[0][0]==-1? new int[]{0,0} : new int[]{dp[0][0], paths[0][0]};
    } 
}