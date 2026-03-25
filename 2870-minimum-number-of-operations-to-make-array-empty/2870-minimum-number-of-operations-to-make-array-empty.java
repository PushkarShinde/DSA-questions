class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int ops=0;
        for(int v:map.values()){
            if(v==1) return -1;
            if(v%3==0){
                ops+=v/3;
                continue;
            }
            
            while(v>0){
                if(v%3==0){
                    ops+=v/3;
                    break;
                }
                v-=2;
                ops++;
            }
        }
        return ops;
    }
}