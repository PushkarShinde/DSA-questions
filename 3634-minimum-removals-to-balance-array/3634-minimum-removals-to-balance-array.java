class Solution {
    public int minRemoval(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        TreeMap<Integer, List<Integer>> map=new TreeMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i], x->new ArrayList<>()).add(i);
        }
        int keep=0;
        for(int i=0;i<n;i++){
            int cur=nums[i];
            Integer key=map.floorKey(cur*k);
            if(key==null) continue;
            List<Integer> pos=map.get(key);
            int r=pos.get(pos.size()-1);
            keep=Math.max(keep, r-i+1);
        }
        return n-keep;
    }
}