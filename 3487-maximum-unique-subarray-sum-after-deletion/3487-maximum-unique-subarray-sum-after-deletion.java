class Solution {
    public int maxSum(int[] nums) {
        boolean[] map=new boolean[201];
        int sum = 0;
        
        for(int i:nums){
            map[i+100]=true;
        }
        boolean isPos=false;
        for(int i=200;i>=0;i--){
            if(isPos && i==99) {
                break;
            }else{
                if(i<100 && map[i]==true){
                    sum+=(i-100);
                    break;
                }
            }
            if(i>=100 && map[i]==true) {
                isPos=true;
                sum+=(i-100);
            }
        }
        return sum;
    }
}