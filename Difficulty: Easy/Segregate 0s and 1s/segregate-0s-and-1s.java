class Solution {
    void segregate0and1(int[] arr) {
        int n=arr.length;
        int r=n-1;
        for(int l=0;l<n;l++){
            while(r>0 && arr[r]==1) r--;
            if(r<=l || r<0) break;
            if(arr[l]==0) continue;
            arr[l]=0;
            arr[r]=1;
        }
    }
}
