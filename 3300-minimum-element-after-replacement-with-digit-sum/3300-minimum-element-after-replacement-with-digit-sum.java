class Solution {
    public int minElement(int[] nums) {
        int n=nums.length;
        int res=100;
        for(int i=0;i<n;i++){
            int sum=0;
            int num=nums[i];
            while(num>0){
                sum+=num%10;
                num/=10;
            }
            res=Math.min(res,sum);
        }
        return res;
    }
}