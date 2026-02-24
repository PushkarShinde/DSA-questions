class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        int n=a1.length;
        int res=0;
        int s1=0;
        int s2=0;
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<n;i++){
            s1+=a1[i];
            s2+=a2[i];
            int dif=s1-s2;
            if(!map.containsKey(dif)){
                map.put(dif, i);
            }else{
                res=Math.max(res,i-map.get(dif));
            }
        }
        return res;
    }
}