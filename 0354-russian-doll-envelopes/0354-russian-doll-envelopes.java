class Solution {
    public int maxEnvelopes(int[][] nums) {
        Arrays.sort(nums, (a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            return b[1]-a[1];
            //desc me karenge taki lis equal width ke envelopes na uthaye
        });
        int n=nums.length;
        int[] tails=new int[n];
        int size=0;
        for(int[] env:nums){
            int h=env[1];
            int l=0, r=size;
            while(l<r){
                int mid=l+(r-l)/2;
                if(tails[mid]<h){
                    l=mid+1;
                }else{
                    r=mid;
                }
            }
            tails[l]=h;
            if(l==size) size++;
        }
        return size;
    }
}