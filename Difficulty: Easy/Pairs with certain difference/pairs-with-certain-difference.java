class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        int n=arr.length;
        if(n<2) return 0;
        Arrays.sort(arr);
        
        int[] dp=new int[n];
        //dp[i]=i tak max sum of distinct pairs
        for(int i=1;i<n;i++){
            dp[i]=dp[i-1];
            if(arr[i]-arr[i-1]<k){
                int sum=arr[i]+arr[i-1];
                if(i>=2){
                    sum+=dp[i-2];
                }
                dp[i]=Math.max(sum, dp[i]);
            }
        }
        return dp[n-1];
    }
}