class Solution {
    private static final int MOD = 1_000_000_007;
    private long power(long base, long exp){
        long res=1;
        while(exp>0){
            if ((exp & 1) == 1) res = (res * base) % MOD;
            /*
            (exp & 1) checks if the last bit is 1.
            If yes, multiply the current base to the result.
            This is equivalent to saying: "Include this power of base in the result."
            */
            base = (base*base) % MOD;
            // Square the base to move to the next bit's corresponding power.
            exp>>=1;
            /*
            Right shift exp by 1 bit (divide by 2).
            We're moving to the next bit in binary.
            */
        }
        return res;
    }
    public int countGoodNumbers(long n) {
        int num=1;
        if(n==1) return 5;
        long even=(n+1)/2;
        long odd=n/2;
        long evenRes=power(5,even);
        long oddRes=power(4,odd);
        return (int)((evenRes*oddRes)%MOD);
    }
}