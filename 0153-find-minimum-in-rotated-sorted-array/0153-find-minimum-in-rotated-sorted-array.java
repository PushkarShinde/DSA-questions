class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int l=0, r=n-1;
        // int res=0;

        while(l<r){
            int mid=l+(r-l)/2;
            int num=nums[mid];

            if(num>nums[r]){ //left is sorted, right has the minimum
                // res=num;
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return nums[l];
    }
}