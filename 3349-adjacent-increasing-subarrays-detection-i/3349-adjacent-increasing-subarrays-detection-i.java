class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n=nums.size();
        for(int i=0;i+2*k<=n;i++){
            if(inc(nums, i, i+k-1) && inc(nums, i+k, i+2*k-1)){
                return true;
            }
        }
        return false;
    }
    private boolean inc(List<Integer> nums, int i, int j){
        for(int k=i;k<j;k++){
            if(nums.get(k)>=nums.get(k+1)) return false;
        }
        return true;
    }
}