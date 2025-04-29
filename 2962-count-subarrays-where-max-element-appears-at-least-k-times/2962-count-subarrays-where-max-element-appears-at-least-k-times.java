class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        int maxNum=0;
        for(int i=0;i<n;i++){
            maxNum=Math.max(maxNum, nums[i]);
        }
        long count=0;
        int freq=0;
        int l=0;
        for(int r=0;r<n;r++){
            if(nums[r]==maxNum) freq++;
            while(freq==k){
                count+=n-r;
                if(nums[l]==maxNum) freq--;
                l++;
            }
        }
        return count;
    }
}