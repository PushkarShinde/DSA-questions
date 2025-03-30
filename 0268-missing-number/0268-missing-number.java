class Solution {
    public int missingNumber(int[] nums) {
        int sumnum=0;
        for(int i:nums){
            sumnum+=i;
        }
        int n=nums.length;
        int sum=n*(n+1)/2;
        return sum-sumnum;
    }
}