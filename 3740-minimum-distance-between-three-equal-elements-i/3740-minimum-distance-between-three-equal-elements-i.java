class Solution {
    public int minimumDistance(int[] nums) {
        int n=nums.length;
        int minDist=400;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]==nums[j] && nums[j]==nums[k]){
                        minDist=Math.min(minDist, Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i));
                    }
                }
            }
        }
        return minDist==400?-1:minDist;
    }
}