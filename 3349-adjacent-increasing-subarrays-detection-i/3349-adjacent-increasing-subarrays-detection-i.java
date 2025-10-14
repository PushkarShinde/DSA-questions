class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n=nums.size();
        if(k==1) return true;
        boolean[] inc=new boolean[n-k+1];
        Arrays.fill(inc, true);
        for(int i=0;i<=n-k;i++){
            for(int j=i;j<i+k-1;j++){
                if(nums.get(j)>=nums.get(j+1)){
                    inc[i]=false;
                    break;
                }
            }
        }
        for(int i=0;i+k<inc.length;i++){
            if(inc[i]==true && inc[i+k]==true) return true;
        }
        return false;
    }
}