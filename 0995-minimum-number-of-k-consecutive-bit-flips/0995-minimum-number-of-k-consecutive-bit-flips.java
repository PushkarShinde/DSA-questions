class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n=nums.length;
        boolean[] flip=new boolean[n];
        int res=0;
        int flips=0;
        for(int i=0;i<n;i++){
            if(i>=k && flip[i-k]) flips--;
            if(flips%2==nums[i]){
                if(i+k>n) return -1;
                flip[i]=true;
                flips++;
                res++;
            }
        }
        return res;
    }
}