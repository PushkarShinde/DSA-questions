class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        
        int res=0;
        if(n%2!=0){
            int avg=nums[n/2];
            for(int i:nums){
                res+=Math.abs(i-avg);
            }
        }else{
            int ct1=0, ct2=0;
            int avg1=nums[n/2];
            int avg2=nums[(n/2)-1];
            for(int num:nums){
                ct1+=Math.abs(num-avg1);
                ct2+=Math.abs(num-avg2);
            }
            res=Math.min(ct1, ct2);
        }

        return res;
    }
}