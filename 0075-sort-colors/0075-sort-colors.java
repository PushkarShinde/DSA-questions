class Solution {
    private void swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public void sortColors(int[] nums) {
        /*
        BRUTE!!
        Arrays.sort(nums);
        */

        /*
        BETTER!!

        int zero=0, one=0, two=0;
        for(int i:nums){
            if(i==0) zero++;
            if(i==1) one++;
            if(i==2) two++;
        }
        for(int i=0;i<nums.length;i++){
            if(i<zero) nums[i]=0;
            if(i>=zero && i<one+zero) nums[i]=1;
            if(i>=one+zero && i<two+one+zero) nums[i]=2;
        }
        */
        
        /*
        OPTIMAL
        -> DUTCH NATIONAL FLAG ALGORITHM
        */
        int mid=0, low=0, high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums, mid, low);
                low++; mid++;
            } 
            else if(nums[mid]==1) mid++;
            else {
                swap(nums, mid, high);
                high--;
            }
        }

        /* WOW!!! */
    }
}