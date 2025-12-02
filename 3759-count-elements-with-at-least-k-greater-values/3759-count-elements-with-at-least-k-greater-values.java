class Solution {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        for(int i=0;i<n-k;i++){
            if(n-upperBound(0,n-1,nums[i],nums)>=k) count++;
        }
        return count;
    }
    private int upperBound(int l, int r, int num, int[] nums){
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