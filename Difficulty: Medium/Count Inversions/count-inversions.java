class Solution {
    static int res;
    static int inversionCount(int arr[]) {
        res=0;
        int n=arr.length;
        solve(arr,0,n-1);
        return res;
    }
    static void solve(int[] a, int l, int r){
        int n=a.length;
        if(l<r){
            int mid=l+(r-l)/2;
            solve(a,l,mid);
            solve(a,mid+1, r);
            merge(a,l,mid,r);
        }
    }
    static void merge(int[] a, int l, int mid, int r){
        int n1=mid-l+1;
        int n2=r-mid;
        int[] a1=new int[n1];
        int[] a2=new int[n2];
        for(int i=l;i<=mid;i++){
            a1[i-l]=a[i];
        }
        for(int i=mid+1;i<=r;i++){
            a2[i-mid-1]=a[i];
        }
        int i=0, j=0, k=l;
        while(i<n1 && j<n2){
            if(a1[i]<=a2[j]){
                a[k]=a1[i];
                i++;
            }else{
                a[k]=a2[j];
                res+=n1-i;
                j++;
            }
            k++;
        }
        while(i<n1){
            a[k]=a1[i];
            i++;k++;
        }
        while(j<n2){
            a[k]=a2[j];
            j++;k++;
        }
    }
}