class Solution {
    public int largestPrime(int n) {
        if(n<2) return 0;
        int sum=0;
        boolean[] primes=sieve(n);
        for(int i=0;i<=n;i++){
            if(primes[i]){
                if(sum+i>n) break; 
                sum+=i;
            }
        }
        return sum;
    }
    private boolean[] sieve(int n){
        boolean[] isPrime=new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        return isPrime;
    }
}