class Solution {
    private boolean solve(int[] nums, int sum, int i){
        if(sum==0) return true;
        if(i==nums.length) return false;
        if(sum<nums[i]) return false;
        if(sum==nums[i]) return true;
        boolean take=solve(nums,sum-nums[i],i+1);
        boolean notTake=solve(nums,sum,i+1);
        return take || notTake; // wow, ab jisme bhi true aya ho humara answer true hi ayega!
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sumFull=0;
        for(int i:nums){
            sumFull+=i;
        }
        if(sumFull%2!=0) return false;
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
        int sumHalf=sumFull/2;
        boolean[] dp=new boolean[sumHalf+1];
        dp[0]=true;
        // The dp[i] tells you: "Can we make sum = i using any subset of the array?"
        // dp[0] = true because you can always make sum 0 — by taking nothing (the empty subset).
        dp[0] = true; // Base case: subset sum of 0 is always possible
        for (int num : nums) {
            for (int i = sumHalf; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sumHalf];
    }
}