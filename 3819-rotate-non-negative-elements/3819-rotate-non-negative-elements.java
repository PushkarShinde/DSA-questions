class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int n=nums.length;
        List<Integer> pos=new ArrayList<>();
        for(int i:nums){
            if(i>=0) pos.add(i);
        }
        int m=pos.size();
        if(m==0) return nums;
        k%=m;
        int[] rotated=new int[m];
        for(int i=0;i<m;i++){
            rotated[i]=pos.get((i+k)%m);
        }
        int[] res=new int[n];
        int in=00;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                res[i]=nums[i];
            }else{
                res[i]=rotated[in];
                in++;
            }
        }
        return res;
    }
}