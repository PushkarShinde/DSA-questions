class Solution {
    public int countNegatives(int[][] grid) {
        int neg=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=grid.length-1;i>=0;i--){
            int left=0, right=n-1;
            int first=n;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(grid[i][mid]<0){
                    first=mid;
                    right=mid-1;
                }else left=mid+1;
            }
            neg+=(n-first);
        }
        return neg;
    }
}