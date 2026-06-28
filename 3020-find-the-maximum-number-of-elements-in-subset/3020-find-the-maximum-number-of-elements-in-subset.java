class Solution {
    public int maximumLength(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer> map=new HashMap<>();
        // Map<Integer, Integer> dp=new HashMap<>();
        for(int x:nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        int res=0;
        if(map.containsKey(1)){
            int one=map.get(1);
            if((one&1)==0){
                one--;
            }
            res=Math.max(one, res);
            map.remove(1);
        }

        long limit=(long)1e9;
        for(int x:map.keySet()){
            int len=0;
            long next=x;

            while(next<=limit && map.containsKey((int)next) && map.get((int)next)>=2){
                len+=2;
                next=next*next;
            }
            if(next<=limit && map.containsKey((int)next)){
                len++;
            }else{
                len--;
            }

            // dp.put(x,Math.max(dp.getOrDefault(x,0), len));
            res=Math.max(Math.max(1,len), res);
        }

        return res;
    }
}