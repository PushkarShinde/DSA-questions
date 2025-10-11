class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map=new HashMap<>();
        for(int i: power){
            map.put(i,map.getOrDefault(i,0L)+1);
        }
        List<Integer> key=new ArrayList<>(map.keySet());
        Collections.sort(key);
        int n=key.size();
        long[] dp=new long[n];
        dp[0]=key.get(0)*map.get(key.get(0));
        for(int i=1;i<n;i++){
            long val=key.get(i)*map.get(key.get(i));
            
            dp[i]=dp[i-1];// op 1: skip key

            //op 2: take this i and find a j that suits our needs
            int j=i-1;
            while(j>=0 && key.get(i)-key.get(j)<=2) j--;
            long include=val+(j>=0?dp[j]:0);
            dp[i]=Math.max(include, dp[i]);
        }
        return dp[n-1];
    }
}