class Solution {
    public int countPrimes(int n) {
    //     int count=0; 
    //     for(int i=2;i<n;i++){
    //         if(isPrime(i))count++;
    //     }
    //     return count;
    // }
    // private boolean isPrime(int n) {
    //     if(n<2) return false;
    //     for(int i=2;i*i<=n;i++){
    //         if(n%i==0) return false;
    //     }
    //     return true;
        if(n<2) return 0;
        boolean[] isPrime=new boolean[n]; 
        Arrays.fill(isPrime, true);

        isPrime[0]= isPrime[1]= false;

        for(int i=2;i*i<n;i++){
            if(isPrime[i]==true) {
                for(int j=i*i;j<n;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        int count=0;
        for(boolean i: isPrime){
            if(i==true) count++;
        }
        return count;
    }
}