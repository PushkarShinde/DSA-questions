class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        int n=arr.length;
        int minNum=Integer.MAX_VALUE;
        for(int i:arr){
            minNum=Math.min(i, minNum);
        }
        int l=minNum, r=minNum+k;
        int ans=l;
        while(l<=r){
            int mid=l+(r-l+1)/2;
            if(possible(arr, k, w, mid)){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
    private boolean possible(int[] arr, int k, int w, int m){
        // Can we achieve a minimum height of m using at most k waterings?
        //line sweep!!
        int n=arr.length;
        long[] diff = new long[n + 1]; // difference array for range-update tracking
        long extra=0;
        long watering=0;
        for(int i=0;i<n;i++){
            extra+=diff[i];
            long effective=arr[i]+extra;
            if(effective<m){
                long need=m-effective;
                watering+=need;
                if(watering>k) return false;
                extra+=need;
                // The boost from these 'need' waterings ends after index i+w-1
                int end=i+w;
                if(end<=n){
                    diff[end]-=need;
                }
            }
        }
        return watering<=k;
    }
}









