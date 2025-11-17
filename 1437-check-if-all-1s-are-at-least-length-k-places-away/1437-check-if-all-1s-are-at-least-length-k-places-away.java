class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n=nums.length;
        int pre=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==0) continue;
            if(pre==-1){
                pre=i;
            }else{
                if(i-pre-1<k) return false;
                pre=i;
            }
        }
        return true;
    }
}