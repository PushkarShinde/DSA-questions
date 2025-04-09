class Solution {
    public int minOperations(int[] nums, int k) {
        int n=nums.length;
        /////////////////////////////////////////////
        if(n==1 && nums[0]==k) return 0;
        if(n==1 && nums[0]>k) return 1;
        if(n==1 && nums[0]<k) return -1;
        int same=0;
        for(int i:nums){    
            if(i==k) same++;
            if(i<k) return -1;
        }
        if(same==n) return 0;
        /////////////////////////////////////////////
        /*
        For each distinct value x > k, you need an operation to reduce it to some h, 
        and then the next, and so on, until you reach k.
        So the answer is basically the number of distinct values in nums that are greater than k. 
        */
        boolean[] greater=new boolean[101];
        for(int i:nums){
            if(i>k){
                greater[i]=true;
            }
        }
        int res=0;
        for(boolean i:greater){
            if(i==true){
                res++;
            }
        }
        return (res!=0)?res:-1;
    }
}