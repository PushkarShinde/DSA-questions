class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res=new ArrayList<>();
        int n=nums.length;
        int num=0;
        for(int i=0;i<n;i++){
            num=((num*2)+nums[i])%5;
            if(num==0) res.add(true);
            else res.add(false);
        }
        return res;
    }
}