class Solution {
    // private long mod=(long)1e9+7;
    // private long[] fact;
    // private long[] reverse;
    // private long power(long a, long b){
    //     long res=1;
    //     while(b>0){
    //         if((b&1)==1) res=(res*a)%mod;
    //         a=(a*a)%mod;
    //         b>>=1;
    //     }
    //     return res;
    // }
    public int uniquePaths(int m, int n) {
        // int size=n+m+5;
        // reverse=new long[size];
        // fact=new long[size];

        // fact[0]=1;
        // for(int i=1;i<size;i++){
        //     fact[i]=(fact[i-1]*i)%mod;
        // }

        // reverse[size-1]=power(fact[size-1],mod-2);
        // for(int i=size-2;i>=0;i--){
        //     reverse[i]=(reverse[i+1]*(i+1))%mod;
        // }

        // int total=n+m-2;
        // long res=((fact[total]*reverse[m-1])%mod*reverse[n-1])%mod;
        // return (int)res;

        long res=1;
        int size=n+m-2;
        int r=Math.min(n-1,m-1);
        for(int i=1;i<=r;i++){
            res=res*(size-r+i)/i;
        }

        return (int)res;
    }
}