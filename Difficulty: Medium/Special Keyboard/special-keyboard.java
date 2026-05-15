class Solution {
    /*
    dp[i] = maximum number of A's achievable with exactly i key presses
    
    For each state, we can:
    - Type 'A': dp[i] = dp[i-1] + 1
    - Copy and paste: Try all possible breaking points
    */
    public int optimalKeys(int n) {
        int res=0;
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i]=i;//key 1 operation
        }
        for(int i=7;i<=n;i++){
            for(int j=1;j<i-2;j++){
                // After j presses, we have dp[j] A's
                // Use 2 presses for Select All + Copy
                // Remaining: i - j - 2 presses for Paste
                int pasteCount=i-j-2;
                
                // Total A's: dp[j] * (1 + pasteCount)
                // Original dp[j] + dp[j] * pasteCount
                dp[i]=Math.max(dp[i], dp[j]*(1+pasteCount));
            }
        }
        return dp[n];
    }
}