class Solution {
    public int maxScore(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int res=Integer.MIN_VALUE;
    
        //har row pe kadane
        for(int i=0;i<n;i++){
            res=Math.max(res, solve(grid[i]));
        }

        // maybe the intersection point is only one
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                res=Math.max(res, grid[i][j]);
            }
        }

        //har col pe kadane lagayenge 
        for(int j=0;j<m;j++){
            int[] a=new int[n];
            for(int i=0;i<n;i++){
                a[i]=grid[i][j];
            }
            res=Math.max(res, solve(a));
        }

        return res;
    }

    private int solve(int[] a){
        int n=a.length;
        int best=a[0]+a[1];
        int res=best;
        for(int i=2;i<n;i++){
            best=Math.max(best+a[i], a[i-1]+a[i]);
            res=Math.max(res, best);
        }
        return res;
    }
}