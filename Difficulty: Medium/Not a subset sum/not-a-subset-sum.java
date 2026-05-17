class Solution {
    public int findSmallest(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int r=1;
        for(int i:arr){
            if(i>r){
                break;
            }
            
            r+=i;
        }
        return r;
    }
    // private boolean valid(int[] a, int val){
    //     int l=0;
    //     int n=a.length;
    //     int sum=0;
    //     for(int r=0;r<n;r++){
    //         sum+=a[r];
    //         while(sum>val){
    //             sum-=a[l];
    //             l++;
    //         }
    //         if(sum==val) return true;
    //     }
    //     return false;
    // }
}