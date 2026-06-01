class Solution {
    private long mod=(long)1e9+7; 
    public int findMaxProduct(int[] arr) {
        int n=arr.length;
        if(n==1) return arr[0];
        
        int pos=0, neg=0, zero=0;
        long allProd=1;
        for(int i:arr){
            if(i>0) pos++;
            if(i<0) neg++;
            if(i==0) zero++;
            allProd=(allProd*i)%mod;
        }
        if(zero==n || (neg==1 && zero>0 && pos==0)) return 0;
        if(zero==0 && (neg&1)==0) return (int)allProd;
        
        Arrays.sort(arr);
        
        long prod=1;
        if((neg&1)==1) neg--;
        for(int i=0;i<neg;i++){
            prod=(prod*arr[i])%mod;
        }
        for(int i=n-1;i>n-1-pos;i--){
            prod=(prod*arr[i])%mod;
        }
        return (int)prod;
    }
}