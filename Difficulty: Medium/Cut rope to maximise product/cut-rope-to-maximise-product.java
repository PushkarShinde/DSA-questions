class Solution {
    int n;
    public int maxProduct(int n) {
        int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // dp[2]=1;
        // dp[1]=0;
        for(int i=2;i<=n;i++){
            int best=0;
            for(int p=1;p<=i/2;p++){
                int a=p, b=i-p;
                a=Math.max(a, dp[a]);
                b=Math.max(b, dp[b]);
                
                int gain=a*b;
                best=Math.max(gain, best);
            }
            dp[i]=best;
        }
        
        return dp[n];
    }
    // private int solve(int r, int l, int i){
    //     if(l>r) return 1;
    //     int gain=l*r;
    //     int res=0;
    //     for(int i=1;i<total;i++){
    //         res=Math.max(solve(total, ))
    //     }
    // }
}