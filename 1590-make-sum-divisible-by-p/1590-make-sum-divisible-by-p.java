class Solution {
    //[3,1,4,2]  k=6
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        long total=0;
        
        for(int i:nums) total+=i;
        int target=(int)(total%p);
        if(target==0) return 0;
        
        Map<Integer, Integer> map=new HashMap<>(); //(prefix mod,index)
        map.put(0,-1);
        
        long prefix=0;
        int res=nums.length;

        for(int i=0;i<n;i++){
            prefix+=nums[i];
            int cur=(int)(prefix%p); //prefix[j]
            int needed=(cur-target+p)%p; //prefix[i]
            // (prefix[j] - prefix[i]) % p == target
            // --> prefix[i] % p == (prefix[j] - target + p) % p
            if(map.containsKey(needed)){
                res=Math.min(res,i-map.get(needed));
            }
            map.put(cur, i);
        }
        return res==nums.length?-1:res;
    }
}