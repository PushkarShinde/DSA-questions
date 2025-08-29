class Solution {
    public long flowerGame(int n, int m) {
        long on=((n+1L)/2);
        long en=n/2;
        long om=((m+1L)/2);
        long em=m/2;

        return on*em +om*en;
    }
}