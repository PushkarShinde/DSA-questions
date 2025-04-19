class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;
        if(n==2) return (nums[0]>nums[1])?0:1; 
        // very imp case, becaue your line number 13 condition will cause an IOB ERROR, if these two are not present. 
        if(nums[0]>nums[1]) return 0; // agar pehle peak ho toh wahi return kar do
        if(nums[n-1]>nums[n-2]) return n-1; // agar aakhri peak ho toh wahi return kr do
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
// itna bhi tough nahi tha!