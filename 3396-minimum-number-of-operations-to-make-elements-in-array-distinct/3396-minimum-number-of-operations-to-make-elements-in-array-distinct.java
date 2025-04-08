class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        int[] freq=new int[101]; 
        int i=0;
        for(i=n-1;i>=0;i--){
            if(freq[nums[i]]>0) break;
            freq[nums[i]]++; 
        }
        return ((i+1)%3>0)? ((i+1)/3)+1 : (i+1)/3; 
    }
}