class Solution {
    /*
    Range Summary for Pair (a, b):

    Target Range         | Moves
    ---------------------|-------
    [2, min+1)           | 2 moves
    [min+1, sum)         | 1 move
    [sum, sum]           | 0 moves
    (sum, max+limit]     | 1 move
    (max+limit, 2*limit] | 2 moves
    ------------------------------
    Where:
    sum = a + b
    min = min(a, b)
    max = max(a, b)
    */
    public int minMoves(int[] nums, int limit) {
        int n=nums.length;
        // Difference array: diff[t] = change in move count at target t
        int[] dif=new int[2*limit+2];
        for(int i=0;i<n/2;i++){
            int a=nums[i];
            int b=nums[n-1-i];

            int min=Math.min(a,b);
            int max=Math.max(a,b);
            int sum=a+b;

            // For all targets [2, 2*limit], initially assume 2 moves
            // Then adjust for ranges with fewer moves
            
            // Range [2, min+1): 2 moves (no change, already assumed 2)
            dif[2]+=2;
            
            // Range [min+1, sum): 1 move
            dif[min+1]--;// Start needing 1 move (reduce by 1)

            // Range [sum, sum]: 0 moves
            dif[sum]--;// Start needing 0 moves (reduce by 1 more)

            // Range (sum, max+limit]: 1 move
            dif[sum+1]++;// Start needing 1 move (reduce by 1)

            // Range (max+limit, 2*limit]: 2 moves (revert to base)
            dif[max+limit+1]++;
        }
        int ans=Integer.MAX_VALUE;
        int cur=0;
        for(int i=2;i<=2*limit;i++){
            cur+=dif[i];
            ans=Math.min(ans, cur);
        }
        return ans;
    }
}