class Solution {

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod=(int)1e9+7;
        for(int[] q:queries){
            int l=q[0];
            int r=q[1];
            int k=q[2];
            int v=q[3];

            for(int i=l;i<=r;i+=k){
                nums[i]=(int)(((long)nums[i]*v)%mod);
            }
        }
        int res=0;
        for(int i:nums){
            res^=i;
        }

        return res;
    }
}