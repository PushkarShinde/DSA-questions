class Solution {
    private int mod=(int)1e9+7;
    public int countTrapezoids(int[][] points){
        int n=points.length;
        Map<Integer, Integer> map=new HashMap<>();
        for(int[] p: points){
            int y=p[1];
            map.put(y, map.getOrDefault(y,0)+1);
        }
        long res=0;
        long sum=0;
        for(int key:map.keySet()){
            int val=map.get(key);
            long edges=(long)(val*(val-1))/2;
            res=(res+edges*sum)%mod;
            sum=(sum+edges)%mod;
        }
        return (int)res;
    }
}