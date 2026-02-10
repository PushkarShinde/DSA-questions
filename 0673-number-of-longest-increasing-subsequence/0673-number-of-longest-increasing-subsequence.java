class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];//1
        int[] count=new int[n];//1
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int maxLength=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }else if(dp[j]+1==dp[i]){
                        count[i]+=count[j];
                    }
                }
            }
            maxLength=Math.max(maxLength, dp[i]);//lis length
        }
        int res=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxLength){
                res+=count[i];
            }
        }
        return res;
    }
}