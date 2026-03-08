class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int res=-1;
        int n=capacity.length;
        int minCap=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(itemSize<=capacity[i]){
                if(minCap>capacity[i]){
                    minCap=capacity[i];
                    res=i;
                }
            }
        }
        return res;
    }
}