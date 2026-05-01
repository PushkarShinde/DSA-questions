class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;
        int val=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            val+=i*nums[i];
        }
        int res=val;
        for(int i=1;i<n;i++){
            val+=sum-n*nums[n-i];
            res=Math.max(res, val);
        }
        return res;
    }
}