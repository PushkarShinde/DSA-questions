class Solution {
    public int sumFourDivisors(int[] nums) {
        int max=0;
        for(int i:nums){
            max=Math.max(i,max);
        }
        boolean[] prime=sieve(max);
        int ans=0;
        for(int n:nums){
            int sum=sumIfFourDivisors(n, prime);
            ans+=sum;
        }
        return ans;
    }
    private int sumIfFourDivisors(int n, boolean[] prime){
        // Case 1: n = p^3
        int p = (int) Math.round(Math.cbrt(n));
        if (p >= 2 && (long)p * p * p == n && prime[p]) {
            return 1 + p + p * p + n;
        }
        //case 2: n= p*q
        // Case 2: n = p * q (p != q, both prime)
        for (int i=2;i*i<=n;i++){
            if(n%i==0){
                int j=n/i;
                if(i != j && prime[i] && prime[j]){
                    return 1+i+j+n;
                }
                return 0;
            }
        }
        return 0;
    }
    private boolean[] sieve(int n){
        boolean[] res=new boolean[n+1];
        Arrays.fill(res,true);
        res[0]=false;
        res[1]=false;
        for(int i=2;i*i<n;i++){
            if(res[i]){
                for(int j=i*i;j<=n;j+=i){
                    res[j]=false;
                }
            }
        }
        return res;
    }
}