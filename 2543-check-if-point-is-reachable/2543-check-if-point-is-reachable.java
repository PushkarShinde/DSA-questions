class Solution {
    public boolean isReachable(int targetX, int targetY) {
        int g=gcd(targetX, targetY);
        
        return (g & (g-1))==0; 
    }

    private int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}