class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i:nums){
            if(map.getOrDefault(i,0)!=0) return i;
            map.put(i,map.getOrDefault(i,0)+1);
        }
        return 0;
    }
}