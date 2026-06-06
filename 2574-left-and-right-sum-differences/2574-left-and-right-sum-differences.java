class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int sum=nums[0];
        int[] pre=new int[n];
        pre[0]=0;
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i-1];
            sum+=nums[i];
        }
        for(int i=0;i<n;i++){
            int left=pre[i];
            int right=sum-(pre[i]+nums[i]);
            pre[i]=Math.abs(left-right);
        }
        return pre;
    }
}