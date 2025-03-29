class Solution {
    public void moveZeroes(int[] nums) {
        int zero=0;
        int n=nums.length;
        if(n==1) return;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zero++;
            }
        }
        int l=n-1, r=n-1;
        while(l<=r && l>=0 && r>=n-zero){
            if(nums[l]==0){
                swap(nums, l, r);
                r--;
            }
            l--;
        }
    }
    public void swap(int[] arr, int l, int r){
        int it=l;
        while(it<r){
            int temp=arr[it];
            arr[it]=arr[it+1];
            arr[it+1]=temp;
            it++;
        }
        // while(l<r){
        //     int temp=arr[r];
        //     arr[r]=arr[l];
        //     arr[l]=temp;
        //     r--; l++;
        // }
    }
}
