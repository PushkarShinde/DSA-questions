class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> ans=new HashMap<>();
        int n=nums.length;
        int[] res=new int[2];
        for(int i=0;i<n;i++){
            int dif=target-nums[i];
            if(ans.containsKey(dif)){
                res[0]=ans.get(dif);
                res[1]=i;
            }else{
                ans.put(nums[i],i);
            }
        }
        return res;
     }
}