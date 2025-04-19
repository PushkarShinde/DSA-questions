class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;
        if(n==2) return (nums[0]>nums[1])?0:1;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        int l=0, r=n-1;
        // array can have multilpe peaks, koi bhi return karo usmese chalega!!
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(nums[mid]>nums[mid-1]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
}