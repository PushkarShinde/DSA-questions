class Solution {
    //LIS
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        int m=strs[0].length();
        int[] dp=new int[m];
        Arrays.fill(dp,1);
        for(int i=0;i<m;i++){
            for(int j=i+1;j<m;j++){
                if(canSolve(i,j,strs)){
                    dp[j]=Math.max(dp[j],dp[i]+1);
                }
            }
        }
        int keep=0;
        for(int x:dp) keep=Math.max(keep,x);
        return m-keep;
    }
    private boolean canSolve(int i,int j,String[] str){
        for(int r=0;r<str.length;r++){
            if(str[r].charAt(i)>str[r].charAt(j)) return false;
        }
        return true;
    }
}