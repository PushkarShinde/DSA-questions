class Solution {
    public int[] buildArray(int[] nums) {
        int n=nums.length;
        // int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int a=nums[nums[i]]%1000;
            nums[i]+=1000*a;
        }
        for(int i=0;i<n;i++){
            nums[i]=nums[i]/1000;
        }
        return nums;
    }
}