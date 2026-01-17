class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n=bottomLeft.length;
        long res=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long v=Math.min(topRight[i][0], topRight[j][0])-
                Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                long h=Math.min(topRight[i][1], topRight[j][1])-
                Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                long side=Math.min(h,v);
                res=Math.max(res,side);
            }
        }
        return res*res;
    }
}