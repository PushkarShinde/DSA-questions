class Solution {
    Map<String, Integer> dp;
    public int totalWays(int[] arr, int target) {
        int n=arr.length;
        dp=new HashMap<>();
        
        return solve(arr, 0, target);
    }
    private int solve(int[] a, int i, int val){
        if(i==a.length){
            if(val==0){
                return 1;
            }else{
                return 0;
            }
        }
        String key=""+i+","+val;
        if(dp.containsKey(key)) return dp.get(key);
        
        int res=0;
        res+=solve(a,i+1,val-a[i]);
        res+=solve(a,i+1,val+a[i]);
        
        dp.put(key, dp.getOrDefault(key,0)+res);
        return res;
    }
}