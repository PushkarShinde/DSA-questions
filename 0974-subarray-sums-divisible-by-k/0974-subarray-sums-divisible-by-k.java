class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res=0;
        int n=nums.length;
        // int[] pre=new int[n];
        // pre[0]=nums[0];
        // for(int i=1;i<n;i++){
        //     pre[i]=pre[i-1]+nums[i];
        // }
        Map<Integer, Integer> map=new HashMap<>();
        int sum=0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int m=sum%k;
            if(m<0) m+=k;
            if(map.containsKey(m)){
                res+=map.get(m);
            }
            map.put(m,map.getOrDefault(m,0)+1);
        }
        return res;
    }
}