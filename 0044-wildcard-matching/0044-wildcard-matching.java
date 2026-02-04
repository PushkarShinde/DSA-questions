class Solution {
    int[][] dp;
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        dp=new int[n+1][m+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return solve(s,p,n,m);
    }
    private boolean solve(String s, String p, int i, int j){
        if(i==0 && j==0) return true;
        if(j==0) return false;
        if(i==0){
            while(j>0){
                if(p.charAt(j-1)!='*') return false;
                j--;
            }
            return true;
        }
        if(dp[i][j]!=-1) return dp[i][j]==1;
        boolean res=false;
        if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
            res=solve(s,p,i-1,j-1);
        }else if(p.charAt(j-1)=='*'){
            //(dono star aur uske parellel p's char is removed || only removed the star ka parellel wala char)
            res=solve(s,p,i,j-1) || solve(s,p,i-1,j);
        }
        dp[i][j]=res?1:0;
        return res;
    }
}