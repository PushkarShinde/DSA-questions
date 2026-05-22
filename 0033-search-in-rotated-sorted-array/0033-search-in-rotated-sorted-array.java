class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0, r=n-1;
        //[4,5,6,7,0,1,2]
        while(l<=r){
            int mid=l+(r-l)/2;
            int num=nums[mid];
            if(num==target) return mid;
            
            if(num>=nums[l]){ //left sorted hai
                if(nums[l]<=target && target<num){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{//right sorted hai
                if(num<target && target<=nums[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}