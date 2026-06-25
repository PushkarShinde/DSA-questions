class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        int f=0;
        for(int i:nums){
            if(i==target) f++;
        }
        if(f==0) return 0;

        int count=0;
        for(int i=0;i<n;i++){
            f=0;
            for(int j=i;j<n;j++){
                int len=j-i+1;
                if(nums[j]==target) f++;
                if(f>len/2) count++;
            }
        }

        return count;
    }
}