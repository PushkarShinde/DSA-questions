class Solution {
    Long[][][] dp;
    int[] a; 
    int[] b;
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int m=nums2.length;
        this.a=nums1;
        this.b=nums2;
        dp=new Long[n+1][m+1][k+1];//(i,j, p) liya toh max kitna score banega with p pairs
        return solve(0, 0, k);
    }
    private long solve(int i, int j, int k){
        if(k==0) return 0L;
        int n=a.length;
        int m=b.length;
        if(i>=n || j>=m) return Long.MIN_VALUE/2;//agar array khatam ho gaya
        if(n-i<k || m-j<k) return Long.MIN_VALUE/2;//agar k pairs banane layak elements hi nahi bache
        if(dp[i][j][k]!=null) return dp[i][j][k];
        long res=Long.MIN_VALUE/2;
        res=Math.max(res, solve(i+1, j, k));//ai ko skip kar de
        res=Math.max(res, solve(i, j+1, k));//bi ko skip kar de

        long score=(long)a[i]*b[j];
        res=Math.max(res, score+solve(i+1, j+1, k-1));
        
        return dp[i][j][k]=res;
    }
}