class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n==1) return 1;
        if(n==0) return 0;
        int count=1;
        int consecutive=1;

        for(int i=0;i<n-1;i++){
            if(nums[i] == nums[i + 1]) continue;
            if(nums[i+1]==nums[i]+1){
                consecutive++;
            }else{
                count=Math.max(consecutive, count);
                consecutive=1;
            }
        }
        return Math.max(consecutive, count);
    }
}