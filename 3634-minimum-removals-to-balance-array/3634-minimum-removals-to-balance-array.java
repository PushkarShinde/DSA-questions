class Solution {
    public int minRemoval(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int keep=0, r=0;
        for(int l=0;l<n;l++){
            int cur=nums[l];
            while(r<n && nums[r]<=(long)cur*k){
                keep=Math.max(keep, r-l+1);
                r++;
            }
        }
        return n-keep;
    }
}