class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        // int[] dp=new int[n];
        // Arrays.fill(dp,-1);
        return solve(nums, 0, n-1);
    }
    // private int solve(int[] nums, int[] dp, int i){
    //     if(i<0) return 0;
    //     if(i==0) return nums[i];
    //     if(dp[i]!=-1) return dp[i];
    //     int pick=nums[i]+solve(nums, dp, i-2);
    //     int notpick=solve(nums, dp, i-1);
    //     dp[i]=Math.max(pick, notpick);
    //     return dp[i];
    // }
    private int solve(int[] nums, int start, int end){
        int pre=0, cur=0;
        for(int i=start;i<=end;i++){
            int temp=cur;
            cur=Math.max(cur, nums[i]+pre);
            pre=temp;
        }
        return cur;
    }
}