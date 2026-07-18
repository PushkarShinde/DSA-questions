class Solution {
    public int findGCD(int[] nums) {
        int min=nums[0];
        int max=nums[0];
        for(int i:nums){
            min=Math.min(i,min);
            max=Math.max(i,max);
        }

        return gcd(min, max);
    }

    private int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}