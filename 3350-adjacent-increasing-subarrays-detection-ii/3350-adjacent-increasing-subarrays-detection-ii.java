class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int preRun=0;
        int curRun=1;
        int max=Integer.MIN_VALUE;
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)>nums.get(i-1)){
                curRun++;
            }else{
                preRun=curRun;
                curRun=1;
            }
            max=Math.max(max,Math.min(preRun, curRun));
            max=Math.max(max,curRun/2);
        }
        return max;
    }
}