class Solution {
    public long minArraySum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int maxNum=0;
        Map<Integer, Long> map=new HashMap<>();
        long sum=0;

        for(int i=0;i<n;i++){
            maxNum=Math.max(maxNum,nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i],0L)+1);
        }

        Set<Integer> vis=new HashSet<>();
        for(int i:nums){
            if(vis.size()==map.size()) break;
            for(int v=i;v<=maxNum;v+=i){
                if(map.containsKey(v) && !vis.contains(v)){
                    sum+=(long)i*map.get(v);
                    vis.add(v);
                }
            }
        }
        return sum;
    }
}