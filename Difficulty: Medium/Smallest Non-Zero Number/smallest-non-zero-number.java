class Solution {
    public int find(int[] arr) {
        int l=0, max=0;
        for(int a:arr){
            max=Math.max(max, a);
        }
        
        int r=max;
        int res=r;
        while(l<=r){
            int mid=l+((r-l)>>1);
            
            if(valid(mid, arr, max)){
                r=mid-1;
                res=mid;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
    
    private boolean valid(int num, int[] a, int max){
        int n=a.length;
        
        for(int i:a){
            int d=num-i;
            num+=d;
            
            if(num<0) return false;
            if(num>=max) return true;
        }
        
        return true;
    }
}
