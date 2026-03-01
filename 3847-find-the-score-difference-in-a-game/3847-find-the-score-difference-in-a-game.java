class Solution {
    public int scoreDifference(int[] nums) {
        int n=nums.length;
        int a=0;
        int b=0;
        boolean flag=true;
        for(int i=0;i<n;i++){
            if(nums[i]%2!=0){
                if(flag) flag=false;
                else flag=true;
            }if((i+1)%6==0){
                if(flag) flag=false;
                else flag=true;
            }
            if(flag){
                a+=nums[i];
            }else{
                b+=nums[i];
            }
        }
        return a-b;
    }
}