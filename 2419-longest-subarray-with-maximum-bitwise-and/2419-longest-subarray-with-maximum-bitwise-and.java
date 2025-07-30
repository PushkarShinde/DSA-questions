class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        if(n==1) return 1;
        int maxEle=0;
        for(int i=0;i<n;i++){
            if(nums[i]>maxEle){
                maxEle=nums[i];
            }
        }
        int contig=0;
        int maxCont=0;
        for(int i=0;i<n;i++){
            if(nums[i]==maxEle){
                contig++;
            }else{
                contig=0;
            }
            maxCont=Math.max(contig, maxCont);
        }
        return maxCont;
    }
}