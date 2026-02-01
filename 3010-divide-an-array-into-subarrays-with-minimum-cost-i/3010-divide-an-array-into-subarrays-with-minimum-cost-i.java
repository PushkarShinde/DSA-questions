class Solution {
    public int minimumCost(int[] nums) {
        int n=nums.length;
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        int ind1=0;
        for(int i=1;i<n;i++){
          if(min1>nums[i]){
            min1=nums[i];
            ind1=i;
          }
        }
        for(int i=1;i<n;i++){
          if(ind1!=i){
            min2=Math.min(min2,nums[i]);
          }
        }
        return nums[0]+min1+min2;
    }
}