class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        
        int[][] pre=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    pre[i][j]=pre[i-1][j-1]+1;
                }else{
                    pre[i][j]=Math.max(pre[i-1][j],pre[i][j-1]);
                }
            }
        }

        int[][] suf=new int[n+2][m+2];
        for(int i=n;i>0;i--){
            for(int j=m;j>0;j--){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    suf[i][j]=suf[i+1][j+1]+1;
                }else{
                    suf[i][j]=Math.max(suf[i+1][j],suf[i][j+1]);
                }
            }
        }
        
        int lcs=pre[n][m];
        int ways=0;
        
        for(int i=0;i<=n;i++){//insertion point
            for(char c='a';c<='z';c++){
                int maxlcs=0;
                
                for(int j=1;j<=m;j++){
                    if(s2.charAt(j-1)==c){
                        int cur=pre[i][j-1]+1+suf[i+1][j+1];
                        maxlcs=Math.max(maxlcs, cur);
                    }
                }
                
                if(maxlcs==lcs+1) ways++;
            }
        }
        
        return ways;
    }
}