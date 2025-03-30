class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOne=Integer.MIN_VALUE;
        int One=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                One=0;
            }else{
                One++;
            }
            maxOne=Math.max(maxOne,One);
        }
        return maxOne;
    }
}