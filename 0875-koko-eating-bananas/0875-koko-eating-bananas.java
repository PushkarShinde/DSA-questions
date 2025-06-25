class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int maxBan=Integer.MIN_VALUE;
        for(int i: piles){
            maxBan=Math.max(maxBan, i);
            // minBan=Math.min(minBan, i);// not valid because kya pata h bahot bada ho
        }
        if(h==n) return maxBan;
        int l=1, r=maxBan;
        while(l<r){
            int mid=l+(r-l)/2;
            if(time(piles,mid)>h){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
    private int time(int[] arr, int h){
        int hrs=0;
        for(int i:arr){
            hrs+=Math.ceil((double)i/h);
        }
        return hrs;
    }
}