class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n=nums.length;
        Map<Integer, Integer> map=new HashMap<>();
        for(int x: nums){
            int mod = ((x % value) + value) % value;
            map.put(mod,map.getOrDefault(mod,0)+1);
        }
        int mex=0;
        while(true){
            int rem=mex%value;
            if(!map.containsKey(rem) || map.get(rem)==0) break;
            map.put(rem,map.get(rem)-1);
            mex++;
        }
        return mex;
    }
}