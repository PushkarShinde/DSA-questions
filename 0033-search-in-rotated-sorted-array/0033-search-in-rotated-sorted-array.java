class Solution {
    private int BS(int[] arr, int t){
        int n=arr.length;
        int l=0,r=n-1;
        int mid=0;
        while(l<=r){
            mid=l+(r-l)/2;
            if(arr[mid]==t) return mid;
            if(arr[mid]>=arr[l]){ // means the left half is sorted
                if(arr[mid]>=t && arr[l]<=t){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{ // means right half is sorted 
                if(arr[mid]<=t && arr[r]>=t){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        return BS(nums, target);
    }
}