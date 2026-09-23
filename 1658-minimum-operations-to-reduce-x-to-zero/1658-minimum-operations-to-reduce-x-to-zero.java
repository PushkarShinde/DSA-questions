class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        
        int total=0;
        for(int a: nums){
            total+=a;
        }

        int target=total-x;

        if(target<0) return -1;
        if(target==0) return n;

        int l=0;
        int sum=0;
        int maxLen=-1;

        for(int r=0;r<n;r++){
            sum+=nums[r];

            while(sum>target && l<=r){
                sum-=nums[l++];
            }

            if(sum==target){
                maxLen=Math.max(maxLen, r-l+1);
            }
        }

        return maxLen==-1?-1: n-maxLen;
    }
}