class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer>[] dp=new HashMap[n];
        for(int i=0;i<n;i++){
            dp[i]=new HashMap<>();
        }
        int res=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int d=nums[i]-nums[j];
                int len=dp[j].getOrDefault(d, 1)+1;
                dp[i].put(d, len);
                res=Math.max(res, len);
            }
        }
        return res;
    }
}