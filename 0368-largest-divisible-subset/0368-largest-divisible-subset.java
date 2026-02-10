class Solution {
    int[] dp;
    List<Integer> res;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        Arrays.sort(nums);
        res=new ArrayList<>();
        int[] parent=new int[n];
        int last=0;
        int lastInd=0;
        for(int i=0;i<n;i++){
            dp[i]=1;
            parent[i]=i;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && nums[i]%nums[j]==0){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        parent[i]=j;
                    }
                }
            }
            if(last<dp[i]){
                last=dp[i];
                lastInd=i;
            }
        }
        res.add(nums[lastInd]);
        while(parent[lastInd]!=lastInd){
            lastInd=parent[lastInd];
            res.add(nums[lastInd]);
        }
        Collections.reverse(res);
        return res;
    }
}