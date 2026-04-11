class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i], k-> new ArrayList<>()).add(i);
        }

        int minDist=(int)4e5;
        for(List<Integer> val: map.values()){
            if(val.size()<3) continue;
            for(int i=2;i<val.size();i++){
                int a=val.get(i-2);
                int b=val.get(i-1);
                int c=val.get(i);
                minDist=Math.min(minDist, Math.abs(a-b)+Math.abs(b-c)+Math.abs(a-c));
            }
        }

        return minDist==(int)4e5?-1:minDist;
    }
}