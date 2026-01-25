class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minRes=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=n-1;i>=k-1;i--){
            int d=nums[i]-nums[i-k+1];
            minRes=Math.min(minRes, d);
        }
        return minRes==Integer.MAX_VALUE?0:minRes;
    }
}