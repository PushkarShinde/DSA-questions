class Solution {
    public int binarySearchable(int[] arr) {
        int count=0;
        int n=arr.length;
        for(int i:arr){
            if(search(arr,i)) count++;
        }
        return count;
    }
    private boolean search(int[] arr,int tar){
        int n=arr.length;
        int l=0, r=n-1;
        while(l<=r){
            int mid=(l+r)>>1;
            int num=arr[mid];
            if(num==tar) return true;
            if(num<tar){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return false;
    }
};