class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sumFull=0;
        for(int i:nums){
            sumFull+=i;
        }
        if(sumFull%2!=0) return false;
        int sumHalf=sumFull/2;
        for(int i:nums){
            if(i>sumHalf) return false;
            else if(i==sumHalf) return true;
        }
        return true;
    }
}