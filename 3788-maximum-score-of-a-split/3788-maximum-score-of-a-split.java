class Solution {
    public long maximumScore(int[] nums) {
        int n=nums.length;
        long pre=0;
        long[] sm=new long[n];
        sm[n-1]=nums[n-1];
        long score=Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--){
            sm[i]=Math.min(sm[i+1],nums[i]);
        }   
        for(int i=0;i<n-1;i++){
            pre+=nums[i];
            score=Math.max(score,pre-sm[i+1]);
        }
        return score;
    }
}