class Solution {
    public static boolean isPowerofTwo(int n) {
        long num=1;
        while(num<=n){
            if(num==n) return true;
            num<<=1;
        }
        return false;
    }
}