class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0.0;
        if(n==0) return 1.0;
        if(n==1) return x; 
        double res=1.0;
        long nn=n; // converting to long

        if(nn<0) {
            x=1/x; //inverse kar diya
            nn=(-1)*nn;
        }
        while(nn>0){
            if(nn%2==1){
                res=res*x;
                nn-=1;
            }
            x*=x;
            nn/=2;
        }
        return res;
    }
    /**
    If n is even → x^n = (x^2)^(n/2)
    If n is odd → x^n = x * (x^2)^(n/2)
    We repeat this process using the idea of exponent halving to reach O(log n) time.
    */
}