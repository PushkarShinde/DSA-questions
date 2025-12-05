class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        pre[0]=nums[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        int count=0;
        for(int i=0;i<n-1;i++){
            int left=pre[i];
            int right=pre[n-1]-pre[i];
            if(Math.abs(right-left)%2==0) count++;
        }
        return count;
    }
}