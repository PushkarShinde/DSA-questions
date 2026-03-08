class Solution {
    long limit=(long)1e14;
    public int smallestBalancedIndex(int[] nums) {
        int n=nums.length;
        long[] prod=new long[n];
        prod[n-1]=1;
        for(int i=n-2;i>=0;i--){
            if(prod[i+1]>limit/nums[i+1]){
                prod[i]=limit+1;//sum iske upar kabhi nahi jayega
            }else{
                prod[i]=prod[i+1]*nums[i+1];
            }
        }
        long sum=0;
        for(int i=0;i<n;i++){
            if(sum==prod[i]) return i;
            sum=sum+nums[i];
        }
        return -1;
    }
}