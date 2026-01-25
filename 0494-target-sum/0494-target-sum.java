class Solution {
    /**
    sum(P) - sum(N) = target
    sum(P) + sum(N) = sum(nums)  (total sum)
    Adding these two equations:
    2 * sum(P) = target + sum(nums)
    sum(P) = (target + sum(nums)) / 2 
    */
    public int findTargetSumWays(int[] nums, int target){
        int n=nums.length;
        int total=0;
        for (int x:nums) total+=x;
        if(Math.abs(target)>total || (target+total)%2!=0) return 0;
        int sum=(target+total)/2;//sum of all positives!
        return solve(nums,sum);
    }
    private int solve(int[] nums, int sum){
        int[] dp=new int[sum+1];
        dp[0]=1;
        for(int n:nums){
            for(int i=sum;i>=n;i--){
                dp[i]+=dp[i-n];
            }
        }
        return dp[sum];
    }
}