class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int start=0;
        int n=nums.length;
        if(n==1) return n;
        int cost=0;
        int maxfreq=1;
        for(int end=1; end<n;end++){
            cost+= (long)(nums[end]-nums[end-1])*(end-start);
            //shrinking phase
            while(cost>k && start<end){
                cost-=(long)nums[end]-nums[start];
                start++;
            }
            maxfreq=Math.max(maxfreq, end-start+1);
            if(maxfreq>29999) maxfreq--;
        }
        return maxfreq;
    }
}