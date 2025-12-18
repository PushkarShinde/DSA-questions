class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        return Math.max(solve(nums, 0,n-2), solve(nums, 1,n-1));
    }
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