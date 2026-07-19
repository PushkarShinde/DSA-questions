class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        boolean[] vis=new boolean[n+1];
        for(int i:nums){
            if(vis[i]) return i;
            vis[i]=true;
        }

        return 69;
    }
}