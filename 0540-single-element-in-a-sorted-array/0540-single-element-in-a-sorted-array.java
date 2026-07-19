class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        int l=0, r=n-2;
        int res=0;
        while(l<=r){
            int mid=l+((r-l)>>1);

            if(nums[mid]!=nums[mid^1]){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return nums[l];
    }
}