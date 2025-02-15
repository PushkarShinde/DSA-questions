class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int n: nums){
            if(digits(n)%2==0){
                count++;
            }
        }
        return count;
    }
    public int digits(int num){
        int count=0;
        while(num>0){
            num/=10;
            count++;
        }
        return count;
    }
}