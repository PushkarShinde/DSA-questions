// Simplified state-transition structure for LeetCode 3225
class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        long[][] prefixSum = new long[n][n + 1];
        
        // 1. Precompute column prefix sums for O(1) range queries
        for (int c = 0; c < n; c++) {
            for (int r = 0; r < n; r++) {
                prefixSum[c][r + 1] = prefixSum[c][r] + grid[r][c];
            }
        }
        
        // 2. DP arrays to track max scores
        // prevPick[i] tracks max score if previous column height was i
        long[] prevPick = new long[n + 1];
        long[] prevSkip = new long[n + 1];
        
        // 3. Evaluate transitions column by column
        for (int j = 1; j < n; j++) {
            long[] currPick = new long[n + 1];
            long[] currSkip = new long[n + 1];
            
            for (int curr = 0; curr <= n; curr++) {
                for (int prev = 0; prev <= n; prev++) {
                    if (curr > prev) {
                        // Current column is taller: scores white cells in previous column
                        long score = prefixSum[j - 1][curr] - prefixSum[j - 1][prev];
                        currPick[curr] = Math.max(currPick[curr], prevSkip[prev] + score);
                        currSkip[curr] = Math.max(currSkip[curr], prevSkip[prev] + score);
                    } else {
                        // Previous column is taller: scores white cells in current column
                        long score = prefixSum[j][prev] - prefixSum[j][curr];
                        currPick[curr] = Math.max(currPick[curr], prevPick[prev] + score);
                        currSkip[curr] = Math.max(currSkip[curr], prevPick[prev]);
                    }
                }
            }
            prevPick = currPick;
            prevSkip = currSkip;
        }
        
        // 4. Return the maximum achievable score
        long max = 0;
        for (long val : prevPick) max = Math.max(max, val);
        return max;
    }
}