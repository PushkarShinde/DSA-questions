class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int n=nums.length;
        int[] prefix=new int[n];
        prefix[0]=nums[0]; 
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int minRes=Integer.MAX_VALUE;
        for(int right=0;right<n;right++){
            while(prefix[right]-prefix[left]>=target){
                left++;
                minRes=Math.min(right-left+1, minRes);
                // return right-left+1;
            }
        }
        return minRes==Integer.MAX_VALUE?0:minRes;
    }
}