class Solution {
    public long sumAndMultiply(int n) {
        long x=0;
        long sum=0;
        int dig=1;
        while(n>0){
            int d=n%10;
            if(d>0){
                x=(long)d*dig+x;
                dig*=10;
                sum+=(long)d;
            }
            n/=10;
        }

        return sum*x;
    }
}