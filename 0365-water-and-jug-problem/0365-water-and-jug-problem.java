class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if(target%gcd(x,y)!=0) return false;
        if(target>x+y) return false;
        return true;  
    }
    private int gcd(int a, int b){
        return b==0?a:gcd(b, a%b);
    }
}