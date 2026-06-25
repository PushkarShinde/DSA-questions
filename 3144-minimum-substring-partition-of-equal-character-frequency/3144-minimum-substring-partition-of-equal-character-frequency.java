class Solution {
    public int minimumSubstringsInPartition(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=1;i<=n;i++){
            int[] f = new int[26];
            int maxFreq = 0;
            int uniqueChars = 0;
            
            for(int j=i;j>=1;j--){
                int charIndex=s.charAt(j-1)-'a';

                if(f[charIndex]==0) uniqueChars++;
                f[charIndex]++;
                maxFreq = Math.max(maxFreq, f[charIndex]);

                int currentLength = i - j + 1;
                if (maxFreq * uniqueChars == currentLength) {
                    if (dp[j - 1] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], 1 + dp[j - 1]);
                    }
                }
            }
        }

        return dp[n];
    }

    private boolean valid(String s, int l, int r){
        int n=s.length();
        int[] f=new int[26];

        for(int i=l;i<r;i++){
            char c=s.charAt(i);
            f[c-'a']++;
        }

        int pre=-1;
        for(int i=0;i<26;i++){
            if(f[i]==0) continue;
            if(pre==-1){
                pre=f[i];
            }

            if(pre!=-1 && pre!=f[i]){
                return false;
            }
        }
        return true;
    }
}