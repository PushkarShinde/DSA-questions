class Solution {
    private int bs(int[] nums, int l, int r, int target){
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]<target){
                l=mid+1;
            }else if(nums[mid]>target){
                r=mid;
            }else if(nums[mid]==target){
                return mid;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int n=nums.length;
        if(n==1 && nums[0]==target) return 0;
        if(n==1 && nums[0]!=target) return -1;
        int res=bs(nums,0,n,target);
        return (res==-1)? -1:res;
    }
}