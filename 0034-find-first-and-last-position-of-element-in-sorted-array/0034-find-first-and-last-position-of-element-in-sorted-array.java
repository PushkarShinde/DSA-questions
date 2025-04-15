class Solution {
    private int lowerBound(int[] arr,int x){
        int ans=-1;
        int n=arr.length;
        int l=0, r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=x){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    private int upperBound(int[] arr,int x){
        int ans=-1;
        int n=arr.length;
        int l=0, r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>x){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
/*
        BRUTE FORCE
        int l=-1, r=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==target && l==-1){
                l=i; r=i;
            }else if(nums[i]==target && l!=-1){
                r=i;
            }
        }
        return new int[]{l,r}; 
*/

        int lb=lowerBound(nums,target);
        if(lb==-1 || nums[lb]!=target) return new int[]{-1,-1};
        int ub=upperBound(nums,target);
        // If upper bound is -1 (i.e., no element greater than target), we need to use the last index
        if (ub == -1) ub = nums.length;
        
        return new int[]{lb, ub - 1};
    }
}