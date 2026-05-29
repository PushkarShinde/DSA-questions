class Solution {
    int[][] dp;
    public int validGroups(String s) {
        dp=new int[s.length()][1000];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return solve(s, 0, 0);
    }
    
    private int solve(String s, int ind, int pre){
        if(ind==s.length()) return 1;
        if(dp[ind][pre]!=-1) return dp[ind][pre];
        int num=0;
        int res=0;
        for(int i=ind;i<s.length();i++){
            num+=s.charAt(i)-'0';
            if(num>=pre){
                res+=solve(s,i+1,num);
            }
        }
        return dp[ind][pre]=res;
    }
}