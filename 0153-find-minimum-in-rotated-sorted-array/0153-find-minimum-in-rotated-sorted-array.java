class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int l=0, r=n-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[r]<nums[mid]){//left side is sorted, min must be in right
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return nums[l];
    }
}