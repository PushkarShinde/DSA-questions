class Solution {
    class Job{
        int start;
        int end;
        int profit;
        Job(int start, int end, int profit){
            this.start=start;
            this.end=end;
            this.profit=profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        Job[] jobs=new Job[n];

        for(int i=0;i<n;i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a.start, b.start));

        int[] dp=new int[n];
        Arrays.fill(dp, -1);

        return solve(0, jobs, dp);
    }

    private int solve(int i, Job[] jobs, int[] dp){
        int n=jobs.length;
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];

        int skip=solve(i+1, jobs, dp);

        int next=helper(i, jobs);
        int take=solve(next, jobs, dp) + jobs[i].profit;

        return dp[i]=Math.max(take, skip);
    }

    private int helper(int i, Job[] jobs){
        int n=jobs.length;
        
        int end=jobs[i].end;
        int l=i+1, r=n-1;
        int next=n;
        while(l<=r){
            int mid=l+((r-l)>>1);

            if(jobs[mid].start>=end){
                r=mid-1;
                next=mid;
            }else{
                l=mid+1;
            }
        }

        return next;
    }
}