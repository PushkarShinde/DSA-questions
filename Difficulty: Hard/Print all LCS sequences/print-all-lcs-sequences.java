class Solution {
    int[][] dp;
    Map<String, Set<String>> memo;
    public List<String> allLCS(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        memo=new HashMap<>();
        Set<String> res=solve(s1, s2, n,m);
        List<String> result= new ArrayList<>(res);
        Collections.sort(result);
        return result;
    }
    private Set<String> solve(String s1, String s2, int i, int j){
        if(i==0 || j==0){
            Set<String> base=new HashSet<>();
            base.add("");
            return base;
        }
        String key=i+","+j;
        if(memo.containsKey(key)) return memo.get(key);
        Set<String> res=new HashSet<>();
        
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            Set<String> pre=solve(s1,s2,i-1, j-1);
            for(String p: pre){
                res.add(p+s1.charAt(i-1));
            }
        }else{
            if(dp[i-1][j]==dp[i][j]){//means max yaha tha
                Set<String> top=solve(s1, s2, i-1, j);
                res.addAll(top);
            }
            if(dp[i][j-1]==dp[i][j]){//means max yaha tha
                Set<String> bottom=solve(s1,s2,i,j-1);
                res.addAll(bottom);
            }
        }
        memo.put(key,res);
        return res;
    }
}