class Solution {
    int[][] res;
    int[][] mat;
    int n;
    int[][] dp;
    
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        this.mat=mat;
        n=mat.length;
        res=new int[n][n];
        
        dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row, -1);

        boolean path=solve(0,0);
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        if(!path){
            ans.add(new ArrayList<>());
            ans.get(0).add(-1);
            return ans;
        }
        
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
            for(int j=0;j<n;j++){
                ans.get(i).add(res[i][j]);
            }
        }
        return ans;
    }
    
    private boolean solve(int x, int y){
        if(x>n-1 || y>n-1 || mat[x][y]==0) return false;
        if(dp[x][y]==0) return false;
        if(dp[x][y]==1){
            res[x][y]=1;
            return true;
        }
        
        res[x][y]=1;

        if(x==n-1 && y==n-1){
            dp[x][y]=1;
            return true;
        }
        
        int v=mat[x][y];
        for(int i=1;i<=v;i++){
            if(solve(x,y+i)){
                dp[x][y+i]=1;
                return true;
            }
            if(solve(x+i,y)){
                dp[x+i][y]=1;
                return true;
            }
        }
        
        dp[x][y]=0;
        res[x][y]=0;
        return false;
    }
}