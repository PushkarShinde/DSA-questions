class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean one=false;
        boolean zero=false;
        while(n>0){
            if(!one && (n&1)==1) {
                one=true;
                zero=false;
            }
            else if(!zero && (n&1)!=1) {
                one=false;
                zero=true;
            }
            else return false;
            n>>=1;
        }
        return true;
    }
}