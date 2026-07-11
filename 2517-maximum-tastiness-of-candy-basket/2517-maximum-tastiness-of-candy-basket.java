class Solution {
    public int maximumTastiness(int[] price, int k) {
        int n=price.length;
        Arrays.sort(price);
        int l=0, r=price[n-1]-price[0];
        int res=0;
        while(l<=r){
            int mid=l+((r-l)>>1);
            if(valid(mid, price, k)){
                l=mid+1;
                res=mid;
            }else{
                r=mid-1;
            }
        }
        return res;
    }

    private boolean valid(int d, int[] a, int k){
        int n=a.length;
        int low=a[0];
        int count=1;
        for(int i=1;i<n;i++){
            int cur=a[i];
            int dif=cur-low;
            if(dif>=d){
                count++;
                low=cur;
            }
            if(k==count) return true;
        }
        return false;
    }
}