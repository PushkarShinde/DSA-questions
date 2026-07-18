class Solution {
    String s, t;
    List<List<String>> rules;
    public int minCost(String s, String t, List<List<String>> rules, int[] costs) {
        this.s=s;
        this.t=t;
        this.rules=rules;

        int n=s.length();
        int m=rules.size();

        int[] dp=new int[n+1];
        int inf=Integer.MAX_VALUE/2;
        Arrays.fill(dp, inf);
        dp[0]=0;//min cost to match first i characters

        int[] star=new int[m];
        for(int i=0;i<m;i++){
            int st=0;
            for(char c:rules.get(i).get(0).toCharArray()){
                if(c=='*') st++;
            }
            star[i]=st;
        }

        for(int i=0;i<n;i++){
            if(dp[i]==inf) continue;

            if(s.charAt(i)==t.charAt(i)){
                dp[i+1]=Math.min(dp[i+1], dp[i]);
            }

            for(int j=0;j<m;j++){
                String x=rules.get(j).get(0);
                String y=rules.get(j).get(1);
                int len=x.length();

                if(i+len>n) continue;

                if(found(i,x,y)){
                    int total=costs[j]+star[j];
                    dp[i+len]=Math.min(dp[i+len], dp[i]+total);
                }
            }
        }

        return dp[n]>=inf?-1:dp[n];
    }

    private boolean found(int i, String x, String y){
        for(int j=0;j<x.length();j++){
            if(t.charAt(i+j)!=y.charAt(j)) return false;

            char p=x.charAt(j);
            if(p!='*' && p!=s.charAt(i+j)) return false;
        }

        return true;
    }
}