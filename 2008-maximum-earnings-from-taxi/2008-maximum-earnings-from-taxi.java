class Solution {
    long[] dp;
    public long maxTaxiEarnings(int n, int[][] rides) {
        dp=new long[rides.length+1];
        Arrays.fill(dp, -1);

        Arrays.sort(rides, (x,y)->x[0]-y[0]);
        return solve(rides, 0);
    }

    private long solve(int[][] rides, int i){
        int n=rides.length;
        if(i>=n) return 0;

        if(dp[i]!=-1) return dp[i];
        
        long skip=solve(rides, i+1);
        
        int start=rides[i][0];
        int end=rides[i][1];
        int tip=rides[i][2];
        long earn=end-start+tip;

        int next=bs(rides, i, end);
        long take=earn+solve(rides, next);

        return dp[i]=Math.max(take, skip);
    }

    private int bs(int[][] arr, int low, int target){
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid][0]>=target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}