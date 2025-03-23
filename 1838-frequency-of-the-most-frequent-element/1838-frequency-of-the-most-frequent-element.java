class Solution {
    public int maxFrequency(int[] nums, int k) {
        int l=0, r=0;
        Arrays.sort(nums);
        int n=nums.length;
        long winsum=0;
        int maxfreq=1;
        while(l<=r && r<n){
            winsum+=nums[r];
            while(l<=r && (long)(r-l+1)*nums[r]>winsum+k){
                winsum-=nums[l];
                l++;
            }
            maxfreq=Math.max(maxfreq,r-l+1);
            r++;
        }
        return maxfreq;
    }
}