class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer, Integer>  modMap=new HashMap<>();
        modMap.put(0,1); // zero index se start karna h isiliye
        int preSum=0;
        int count=0;
        for(int num:nums){
            preSum+=num;
            int mod=(preSum%k+k)%k; // handle negative mods
            count+=modMap.getOrDefault(mod, 0);
            modMap.put(mod, modMap.getOrDefault(mod, 0)+1);
        }
        return count;
    }   
}