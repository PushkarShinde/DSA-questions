class Solution {
    public long maxSubarraySum(int[] a, int k) {
        long dp0=(long)-1e17;//unmodified pre
        long dp1m=(long)-1e17;//currently multiplying
        long dp2m=(long)-1e17;//unmodified suffix mul 
        long dp1d=(long)-1e17;//currently dividing
        long dp2d=(long)-1e17;//unmodified suffix div

        long maxSum=(long)-1e17;

        for(int num:a){
            long x=(long)num;

            long mult=x*k;
            long div=x/k;

            long ndp2m=Math.max(dp1m+x, dp2m+x);
            long ndp1m=Math.max(mult,Math.max(dp0+mult, dp1m+mult));
            long ndp2d=Math.max(dp1d+x, dp2d+x);
            long ndp1d=Math.max(div,Math.max(dp0+div, dp1d+div));
            long ndp0=Math.max(x, dp0+x);

            dp0=ndp0;
            dp1d=ndp1d;
            dp2d=ndp2d;
            dp1m=ndp1m;
            dp2m=ndp2m;

            maxSum=Math.max(maxSum, Math.max(dp1m, dp2m));
            maxSum=Math.max(maxSum, Math.max(dp1d, dp2d));
        }

        return maxSum;
    }
}