class Solution {
    public int getCount(int n, int d) {
        // int factor=(d+8)/9;
        // if(n<factor*10) return 0;
        // return n-factor*10+1;
        
        int l=1, r=n;
        int ans=n+1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(valid(d,mid)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return n-l+1;
    }
    private boolean valid(int d,int mid){
        int sum=0;
        int x=mid;
        while(x>0){
            sum+=(x%10);
            x/=10;
        }
        
        return mid-sum>=d;
    }
};