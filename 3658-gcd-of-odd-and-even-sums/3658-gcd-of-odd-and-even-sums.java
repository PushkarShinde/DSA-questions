class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd=n*n;
        int sumEven=n*(n+1);

        return gcd(sumOdd, sumEven);
    }

    private int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}