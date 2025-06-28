class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int maxNum=Integer.MIN_VALUE;
        for(int i:nums){
            maxNum=Math.max(i,maxNum);
        }
        if(threshold==n) return maxNum;
        int l=1, r=maxNum;
        while(l<r){
            int mid=l+(r-l)/2;
            if(works(nums, threshold, mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    private boolean works(int[] nums, int threshold, int k){
        long sum=0;
        for(int i:nums){
            sum+=1+((i-1)/k);
        }
        return threshold>=sum;
    }
}