class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int preRun=0;
        int curRun=1;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)>nums.get(i-1)){
                curRun++;
            }else{
                preRun=curRun;
                curRun=1;
            }
            if(curRun>=2*k){
                return true;
            }
            if(Math.min(curRun, preRun)>=k){
                return true;
            }
        }
        return false;
    }
}