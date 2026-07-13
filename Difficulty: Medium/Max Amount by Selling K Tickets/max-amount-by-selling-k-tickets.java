class Solution {
    public int maxAmount(int[] arr, int k) {
        int n=arr.length;
        long res=0;
        long count=1;
        Arrays.sort(arr);
        
        for(int i=n-1;i>=0;i--){
            int cur=arr[i];
            int next=(i>0)?arr[i-1]:0;
            
            if(cur>next){
                int d=cur-next;
                long total=d*count;
                
                if(k>=total){
                    long sum=(cur+next+1)*d/2%mod;
                    res=(res+sum*count)%mod;
                    k-=total;
                }else{
                    long row=k/count;
                    long rem=k%count;
                    long sum=(cur+(cur-row+1))*row/2%mod;
                    res=(res+sum*count)%mod;
                    
                    res=(res+(cur-row)*rem)%mod;
                    k=0;
                    break;
                }
            }
            
            count++;
            
            if(k<=0) break;
        }
        
        return (int)res;
    }
    private long mod=(long)1e9+7;
}