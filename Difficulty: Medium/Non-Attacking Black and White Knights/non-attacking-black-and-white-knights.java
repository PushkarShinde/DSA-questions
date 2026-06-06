class Solution {
    public int numOfWays(int n, int m) {
        long total=(long)n*m*((long)n*m-1);
        long count=0;
        
        int[][] dir={{2,1}, {2,-1},{1,2},{1,-2}};
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                for(int[] d:dir){
                    int nx=i+d[0];
                    int ny=j+d[1];
                    if(nx<=n && ny<=m && nx>0 && ny>0) count++;
                }
            }
        }
        
        return (int)(total-2*count);
    }
}