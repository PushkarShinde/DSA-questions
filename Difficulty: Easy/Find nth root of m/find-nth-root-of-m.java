// User function Template for Java

class Solution {
    public int nthRoot(int n, int m) {
        int l=1, r=m;
        int root=-1;
        if(m==1) return 1;
        if(n==1) return m;
        while(l<=r){
            int mid=l+(r-l)/2;
            long prod=power(mid,m,n);
            if(prod==m){
                return mid;
            }else if(prod<m){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }
    private long power(int mid, int m, int n){
        long res=1;
        for(int i=0;i<n;i++){
            res*=mid;
            if(res>m) return res; //early break
        }
        return res;
    }
}