class Solution {
    public boolean isPowerOfTwo(int n) {
        long num=1;
        while(num<=n){
            if(num==n) return true;
            num<<=1;
        }
        return false;
    }
}