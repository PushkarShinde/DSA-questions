class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n=nums.length;
        Set<Integer> set=new TreeSet<>();
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                set.add(value-(Math.abs(nums[i])%value));
            }
            set.add(nums[i]%value);
        }
        int mex=0;
        while(true){
            if(!set.contains(mex)) break;
            mex++;
        }
        return mex;
    }
}