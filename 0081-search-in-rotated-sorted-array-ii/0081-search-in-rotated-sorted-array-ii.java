class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        int l=0, r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target) return true;
            if(nums[l]==nums[mid] && nums[r]==nums[mid]){
                l++; r--;
            }else if(nums[l]<=nums[mid]){//left side is sorted
                if(target>=nums[l] && nums[mid]>target){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{// right is sorted
                if(target>nums[mid] && nums[r]>=target){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return false;
    }
}