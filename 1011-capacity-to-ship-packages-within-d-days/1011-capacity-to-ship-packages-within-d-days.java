class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int maxw=Integer.MIN_VALUE;
        int minw=Integer.MAX_VALUE;
        int sum=0;
        for(int i:weights){
            maxw=Math.max(i,maxw);
            sum+=i;
        }
        if(n==days) return maxw;
        int l=maxw, r=sum;
        while(l<r){
            int mid=l+(r-l)/2;
            if(works(weights, days, mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return r;
    }
    private boolean works(int[] weights, int days, int ans){
        int weight=0, count=0;
        for(int i:weights){
            weight+=i;
            if(weight>ans){
                count++;
                weight=i;
            }
        }
        return count+1<=days;
    }
}