class Solution {
    public int minMoves(int[] nums, int limit) {
        int n=nums.length;
        int[] dif=new int[2*limit+2];
        for(int i=0;i<n/2;i++){
            int a=nums[i];
            int b=nums[n-1-i];

            int low=Math.min(a,b)+1;
            int high=Math.max(a,b)+limit;
            int sum=a+b;

            dif[2]+=2;
            
            dif[low]--;

            dif[sum]--;
            dif[sum+1]++;

            dif[high+1]++;
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