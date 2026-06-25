class Solution {
    public int minimumBeautifulSubstrings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        Set<Integer> five=new HashSet<>(Arrays.asList(1, 5, 25, 125, 625, 3125, 15625));

        for(int i=1;i<=n;i++){
            int val = 0;
            int base = 1;
            
            for(int j=i;j>=1;j--){
                int bit = s.charAt(j - 1) - '0';

                val += bit * base;
                base<<=1;

                if(bit==0) continue;
                
                if(five.contains(val)){
                    if(dp[j-1]!=Integer.MAX_VALUE){
                        dp[i]=Math.min(dp[i],1+dp[j-1]);
                    }
                }
            }
        }

        return dp[n]==Integer.MAX_VALUE?-1:dp[n];
    }
}