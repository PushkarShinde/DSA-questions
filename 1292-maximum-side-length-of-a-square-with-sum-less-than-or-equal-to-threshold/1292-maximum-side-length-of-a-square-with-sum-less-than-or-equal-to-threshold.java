class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] grid=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                grid[i][j]=grid[i-1][j]+grid[i][j-1] -
                grid[i-1][j-1] + mat[i-1][j-1];
            }
        }
        int l=1;
        int r=Math.min(m,n);
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            boolean find=false;
            for(int i=1;i<=m-mid+1;i++){
                for(int j=1;j<=n-mid+1;j++){
                    int sum=grid[i+mid-1][j+mid-1]-grid[i-1][j+mid-1]-
                    grid[i+mid-1][j-1]+grid[i-1][j-1];
                    if(sum<=threshold){
                        find=true;
                        break;
                    }
                }
                if(find) break;
            }
            if(find){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
}