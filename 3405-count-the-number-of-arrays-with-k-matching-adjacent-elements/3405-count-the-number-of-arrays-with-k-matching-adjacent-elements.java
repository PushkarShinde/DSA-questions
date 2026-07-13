class Solution {
    long[] fact;
    public int countGoodArrays(int n, int m, int k) {
        fact=new long[n+1];
        fact[0]=fact[1]=1;
        for(int i=2;i<=n;i++){
            fact[i]=(fact[i-1]*(i))%mod;
        }

        return (int)((((m*ncr(n-1,k))%mod)*power(m-1,n-k-1))%mod);
    }
    
    private long ncr(int n, int r){
        return (((fact[n]*inverse(fact[r]))%mod)*inverse(fact[n-r]))%mod;
    }
    
    private long inverse(long a){
        return power(a,mod-2);
    }

    private long mod=(long)1e9+7;
    
    private long power(long a, long b){
        long res=1;
        while(b>0){
            if((b&1)==1) res=(res*a)%mod;
            a=(a*a)%mod;
            b>>=1;
        }
        return res;
    }
}