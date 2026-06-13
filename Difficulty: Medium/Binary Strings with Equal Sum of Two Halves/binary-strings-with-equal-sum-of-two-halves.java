class Solution {
    private long mod=(long)1e9+7;
    long[] fact;
    long[] invFact;
    
    public int computeValue(int n) {
        fact=new long[n+1];
        fact[0]=1L;
        for(int i=1;i<=n;i++){
            fact[i]=fact[i-1]*(long)i%mod;
        }
        
        invFact=new long[n+1];
        invFact[n]=power(fact[n],mod-2);
        for(int i=n-1;i>=0;i--){
            invFact[i]=invFact[i+1]*(long)(i+1)%mod;
        }
        
        long res=0;
        for(int i=0;i<=n;i++){
            long term=ncr(n,i);
            res=(res+term*term)%mod;
        }
        return (int)res;
    }
    
    private long power(long a, long b){
        long base=a;
        long res=1;
        while(b>0){
            if((b&1)==1) res=(res*base)%mod;
            base=base*base%mod;
            b>>=1;
        }
        return res%mod;
    }
    
    private long ncr(int n, int r){
        return fact[n]*(invFact[r]*invFact[n-r]%mod)%mod;
    }
}