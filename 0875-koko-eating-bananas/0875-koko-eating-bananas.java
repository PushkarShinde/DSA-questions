class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int total=0;
        for(int i: piles) total+=i;
        int l=(int) ((total - 1) / h) + 1;
        // int l=Math.ceil((double)total/h);
        //This avoids starting the binary search from 1, which is too low if the total is large.
        int r=(int) ((total - n) / (h - n + 1)) + 1;
        /*here’s the logic:
        - Every pile takes at least 1 hour, no matter how fast she eats.
        -So she needs at least n hours, one for each pile.
        -That leaves h - n extra hours, which can help distribute some piles across more time.
        -Based on that, the formula calculates a realistic upper bound for k — a speed beyond which 
        increasing doesn't really help because Koko will still be limited by the per-pile requirement.
        */
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