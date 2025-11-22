class Solution {
    public int findFinalValue(int[] nums, int original) {
        int res=original;
        Arrays.sort(nums);
        while(bs(res,nums)!=-1){
            res*=2;
        }
        return res;
    }
    private int bs(int num, int[] nums){
        int l=0, r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==num) return mid;
            if(nums[mid]>num){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
}
//[5,3,6,1,12] --- 3