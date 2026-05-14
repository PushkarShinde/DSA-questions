class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        int base=0;
        for(int i:nums){
            base=Math.max(base, i);
        }
        if(n-base!=1) return false;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int a=nums[i];
            map.put(a, map.getOrDefault(a, 0)+1);
            if(map.get(a)>1 && a!=base) return false;
        }
        return map.get(base)==2;
    }
}