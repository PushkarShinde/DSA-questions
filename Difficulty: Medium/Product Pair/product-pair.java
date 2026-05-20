class Solution {
    public boolean isProduct(int[] arr, long target){
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=0;i<n;i++){
            int val=arr[i];
            if(val==0){
                if(target==0 && n>1) return true;
                continue;
            }
            if(target%val!=0) continue;
            
            long tar=target/val;
            int ind=binary(arr, tar);
            if(ind!=-1){
                if(ind!=i) return true;
                if(ind>0 && arr[ind-1]==tar) return true; 
                if(ind<n-1 && arr[ind+1]==tar) return true; 
            }
        }
        return false;
    }
    private int binary(int[] a, long tar){
        int l=0, r=a.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]==tar) return mid;
            if(a[mid]>tar){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
}