class Solution {
    public boolean check(int[] nums) {
        int dip=0;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i-1]>nums[i]){
                for(int j=i+1;j<i+n;j++){
                    if(nums[(j-1)%n]>nums[j%n]) return false;
                }
                break;
            }
        }
        return true;
    }
}