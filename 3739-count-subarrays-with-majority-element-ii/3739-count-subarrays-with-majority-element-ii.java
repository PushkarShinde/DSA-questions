class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;

        boolean found=false;
        for(int i:nums){
            if(i==target){
                found=true;
                break;
            }
        }
        if(!found) return 0L;

        int[] map=new int[2*n+1];
        int off=n;
        map[0+off]=1;

        int cum=0;
        long run=0;
        long res=0;
        for(int i=0;i<n;i++){

            if(nums[i]==target){
                run+=map[cum+off];
                cum++;
            }else{
                cum--;
                run-=map[cum+off];
            }

            res+=run;
            map[cum+off]++;
        }

        return res;
    }
}