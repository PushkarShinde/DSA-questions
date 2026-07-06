class Solution {
    int n;
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        n=nums.length;
        int[] pre=new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+nums[i];
        }

        return Math.max(solve(pre, firstLen, secondLen), solve(pre, secondLen, firstLen));
    }

    private int solve(int[] pre, int l, int m){
        int maxL=0;
        int total=0;

        for(int i=l+m;i<=n;i++){
            int curL=pre[i-m]-pre[i-m-l];
            maxL=Math.max(curL, maxL);

            int curM=pre[i]-pre[i-m];
            total=Math.max(total, curM+maxL);
        }

        return total;
    }
}