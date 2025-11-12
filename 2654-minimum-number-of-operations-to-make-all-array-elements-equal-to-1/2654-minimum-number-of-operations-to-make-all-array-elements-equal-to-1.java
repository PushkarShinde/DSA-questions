class Solution {
    public int minOperations(int[] nums) {
        int count=0;
        int n=nums.length;
        int one=0;
        for(int i: nums){
            if(i==1)one++;
        }
        if(one>0) return n-one;
        int minLen=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            int g=nums[i];
            for(int j=i+1;j<n;j++){
                g=gcd(g, nums[j]);
                if(g==1) {
                    minLen=Math.min(minLen,j-i+1);
                    break;
                }
            }
        }
        return minLen==Integer.MAX_VALUE?-1: (n-1)+(minLen-1);
    }

    private int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}