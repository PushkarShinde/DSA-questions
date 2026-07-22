class Solution {
    public int minDeletions(int[] arr) {
        int n=arr.length;
        
        int[] p=new int[n];
        int piles=0;
        for(int a:arr){
            int l=0, r=piles;
            
            while(l<r){
                int mid=(l+r)>>1;
                if(p[mid]<a){
                    l=mid+1;
                }else{
                    r=mid;
                }
            }
            
            p[l]=a;
            
            if(l==piles){
                piles++;
            }
        }
        
        return n-piles;
    }
}