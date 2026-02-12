class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum=0;
        int maxNum=0;
        for(int i:candies){
            sum+=i;
            maxNum=Math.max(maxNum, i);
        }
        if(k>sum) return 0;
        int r=maxNum;
        int l=1;
        while(l<r){
            int mid=l+(r-l+1)/2;
            if(possible(candies, k, mid)){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        return l;
    }
    private boolean possible(int[] a, long k, int m){
        long piles=0;
        for(int i: a){
            if(i>=m){
                piles+=(i/m);
            }
        }
        return piles>=k;
    }
}