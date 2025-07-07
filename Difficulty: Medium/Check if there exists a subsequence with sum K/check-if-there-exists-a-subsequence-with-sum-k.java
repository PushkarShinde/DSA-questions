// User function Template for Java

class Solution {
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
         boolean[][] dp = new boolean[N + 1][K + 1];
    
        // Base case: sum 0 is always possible (empty subsequence)
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }
    
        for (int i = 1; i <= N; i++) {
            for (int sum = 1; sum <= K; sum++) {
                // Exclude current element
                dp[i][sum] = dp[i - 1][sum];
    
                // Include current element if it doesn't exceed sum
                if (sum >= arr[i - 1]) {
                    dp[i][sum] |= dp[i - 1][sum - arr[i - 1]];
                }
            }
        }
    
        return dp[N][K];
    }
}

/**
Step-by-step Explanation:
dp[i][sum]: Can we form sum sum using the first i elements?
dp[i - 1][sum]: We can form this sum without using the i-th element.
dp[i - 1][sum - arr[i - 1]]: Can we form sum sum - arr[i-1] with the first i-1 elements?

dp[i][sum] = dp[i - 1][sum]        // Don't take arr[i - 1]
           OR
           dp[i - 1][sum - arr[i - 1]] // Take arr[i - 1]
           
The |= operator does this succinctly:
dp[i][sum] |= dp[i - 1][sum - arr[i - 1]];
It means:

"If it was already true before (by excluding current), or if we can make sum by including arr[i-1], then mark it true."
*/
