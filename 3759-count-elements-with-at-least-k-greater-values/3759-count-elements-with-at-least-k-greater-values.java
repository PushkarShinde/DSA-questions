class Solution {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(n-upperBound(nums[i],nums)>=k) count++;
        }
        return count;
    }
    private int upperBound(int num, int[] nums){
        int l=0, r=nums.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]<=num){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    } 
}