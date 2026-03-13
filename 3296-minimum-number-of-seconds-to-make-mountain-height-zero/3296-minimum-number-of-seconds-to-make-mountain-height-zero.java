class Solution {
    int height;
    int[] times;
    public long minNumberOfSeconds(int height, int[] times) {
        this.height=height;
        this.times=times;

        long maxH=0;
        for(int i:times) maxH=Math.max(i,maxH);

        long l=1, r=maxH*((long)height*(height+1)/2); 
        long time=0;
        while(l<=r){
            long mid=l+(r-l)/2;
            if(check(mid)){
                time=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return time;
    }

/**
h=(−1+sqrt(1+8T/t))/2;
 */
    private boolean check(long time){
        long total=0;
        for(int t:times){
            double val=Math.sqrt(1.0+(8.0*time)/t);
            long h=(long)((val-1)/2);
            total+=h;
            if(total>=height) return true;
        }
        return total>=height;
    }
}