class Solution {
    public int minSwaps(int[] nums, int[] forbidden) {
        int n=nums.length;
        Map<Integer, Integer> map=new HashMap<>();
        Map<Integer, Integer> bad=new HashMap<>();
        int bads=0;
        for(int i=0;i<n;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            map.put(forbidden[i], map.getOrDefault(forbidden[i],0)+1);
            if(map.get(nums[i])>n || map.get(forbidden[i])>n) return -1;

            if(nums[i]==forbidden[i]){
                bads++;
                bad.put(nums[i], bad.getOrDefault(nums[i],0)+1);
            }
        }
        int maxBad=0;
        for(int i: bad.values()){
            maxBad=Math.max(maxBad,i);
        }
        return Math.max((bads+1)/2,maxBad);
    }
}