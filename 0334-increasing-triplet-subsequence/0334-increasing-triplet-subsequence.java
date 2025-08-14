class Solution {
    public boolean increasingTriplet(int[] nums) {
        int left=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;
        for(int num: nums){
            if(num<=left){
                left=num;
            }else if(num<=right){
                right=num;
            }else{
                return true;
            }
        }
        return false;
    }
}