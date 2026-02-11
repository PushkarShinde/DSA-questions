class Solution {
    public int minCost(int[] heights, int[] cost) {
        int n=heights.length;
        int l=Integer.MAX_VALUE;
        int r=Integer.MIN_VALUE;
        for(int i: heights){
            l=Math.min(i, l);
            r=Math.max(i, r);
        }
        while(l<r){
            int mid=l+(r-l)/2;
            long costMid=solve(cost, heights, mid);
            long costNext=solve(cost, heights, mid+1);
            if(costMid>costNext){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return (int)solve(cost,heights,l);
    }
    private long solve(int[] c, int[] h, int height){
        long cost=0;
        int n=h.length;
        for(int i=0;i<n;i++){
            cost+=(Math.abs(height-h[i])*(long)c[i]);
        }
        return cost;
    }
}
