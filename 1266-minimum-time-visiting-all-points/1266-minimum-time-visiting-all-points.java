class Solution {
    public int minTimeToVisitAllPoints(int[][] points){
        int ans=0;
        int n=points.length;
        for(int i=1;i<n;i++){
            int max=Integer.MIN_VALUE;
            int x=points[i][0], y=points[i][1];
            int xp=points[i-1][0], yp=points[i-1][1];
            max=Math.max(max,Math.abs(x-xp));
            max=Math.max(max,Math.abs(y-yp));
            ans+=max;
        }
        return ans;
    }
}