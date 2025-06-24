class Solution {
    public int mySqrt(int x) {
        int root=0;
        int l=1, r=x;
        if(x==0) return 0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if((long)mid*mid<=x){
                l=mid+1;
                root=mid;
            }else{
                r=mid-1;
            }
        }
        return root;
    }
}