class Solution {
    int[] dp;
    public int minCut(String s) {
        int n=s.length();
        boolean[][] pal=new boolean[n][n];
        for(int end=0;end<n;end++){
            for(int start=0;start<=end;start++){
                if(s.charAt(start)==s.charAt(end) && (end-start<2 || pal[start+1][end-1])){
                    pal[start][end]=true;
                }
            }
        }
        dp=new int[n+1];
        for(int i=0;i<n;i++){
            if(pal[0][i]){
                dp[i]=0;
            }else{
                dp[i]=i;
                for(int j=0;j<i;j++){
                    if(pal[j+1][i]){
                        dp[i]=Math.min(dp[i], dp[j]+1);
                    }
                }
            }
        }
        return dp[n-1];
    }
    /*
    private int solve(String s, int l, int r){
        if(l>=r) return 0;
        if(palindrome(s, l, r)) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int res=(int)1e9;
        for(int k=l;k<r;k++){
            res=Math.min(res,solve(s,l,k)+solve(s,k+1,r)+1);
        }
        return dp[l][r]=res;
    }
    private boolean palindrome(String s, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    */
}