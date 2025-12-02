class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        int n=nums.length;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int newNum=reverse(nums[i]);
            if(map.containsKey(nums[i])){
                res=Math.min(i-map.get(nums[i]), res);
            }
            map.put(newNum, i);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
    private int reverse(int num){
        int res=0;
        while(num>0){
            int rem=num%10;
            res=res*10+rem;
            num/=10;
        }
        return res;
    }
}