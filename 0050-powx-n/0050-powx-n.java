class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0.0;

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
}