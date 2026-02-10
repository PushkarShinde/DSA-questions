class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words, (a,b)->a.length()-b.length());
        int[] dp=new int[n];
        int res=0;
        for(int i=0;i<n;i++){
            dp[i]=1;
            String cur=words[i];
            for(int j=0;j<i;j++){
                String pre=words[j];
                if(pred(pre, cur)){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            res=Math.max(res, dp[i]);
        }
        return res;
    }
    private boolean pred(String a, String b){
        int n=a.length();
        int m=b.length();
        if(m-n!=1) return false;
        int i=0;
        int j=0;
        while(i<n && j<m){
            char pre=a.charAt(i);
            char cur=b.charAt(j);
            if(pre==cur){
                i++;
            }
            j++;
        }
        return i==n;
    }
}