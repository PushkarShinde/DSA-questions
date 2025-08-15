class Solution {
    public boolean isPowerOfFour(int n) {
        double m=n;
        if(m>1 && m%4!=0) return false;
        while(m>1){
            m/=4.0;
        }
        return m==1;
    }
}