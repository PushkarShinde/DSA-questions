class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int[] zero=new int[n+2];
        int ind=0;
        zero[ind]=-1;
        int count=1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero[count++] = i;
            }
        }
        zero[count++] = n;
        if(count==2) return n-1;
        int maxLen=0;
        for(int i=1;i<count-1;i++){
            maxLen=Math.max(zero[i+1]-zero[i-1]-2, maxLen);
        }
        return maxLen;
    }
}