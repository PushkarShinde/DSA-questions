class Solution {
    
    public int maxChocolate(int grid[][]) {
        int n=grid.length;
        int m=grid[0].length;
        
        int[][][] dp=new int[n][m][m];
        
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1!=j2){
                    dp[n-1][j1][j2]=grid[n-1][j1]+grid[n-1][j2];
                }else{
                    dp[n-1][j1][j2]=grid[n-1][j1];
                }
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int maxVal=(int)-1e8;
                    for(int x=-1;x<=1;x++){
                        for(int y=-1;y<=1;y++){
                            int val=0;
                            if(j1==j2){
                                val=grid[i][j1];
                            }else{
                                val=grid[i][j1]+grid[i][j2];
                            }
                            if(j1+x<0 || j1+x>=m || j2+y<0 || j2+y>=m){
                                val+=(int)-1e8;
                            }else{
                                val+=dp[i+1][j1+x][j2+y];;
                            }
                            maxVal=Math.max(maxVal, val);
                        }
                    }
                    dp[i][j1][j2]=maxVal;
                }
            }
        }
        
        
        return dp[0][0][m-1];
    }
    

}