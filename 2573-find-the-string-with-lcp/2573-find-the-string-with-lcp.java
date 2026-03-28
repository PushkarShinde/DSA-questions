class Solution {
    public String findTheString(int[][] lcp) {
        int n=lcp.length;
        char[] word=new char[n];
        char ch='a';
         
        for(int i=0;i<n;i++){
            boolean assigned=false;

            for(int j=0;j<i;j++){
                if(lcp[i][j]>0){
                    word[i]=word[j];
                    assigned=true;
                    break;
                }
            }
            if(!assigned){
                if(ch>'z') return "";
                word[i]=ch++;
            }
        }

        int[][] dp=new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(word[i]==word[j]){
                    dp[i][j]=dp[i+1][j+1]+1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]!=lcp[i][j]){
                    return "";
                }
            }
        }

        return new String(word);
    }
}