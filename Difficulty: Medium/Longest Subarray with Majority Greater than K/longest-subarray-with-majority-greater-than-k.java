class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int num=0;
        int res=0;
        for(int i=0;i<n;i++){
            if(arr[i]<=k) num--;
            else num++;
            if(num>0) res=i+1;
            else{
                if(map.containsKey(num-1)){
                    res=Math.max(res, i-map.get(num-1));
                }
            }
            map.putIfAbsent(num, i);
        }
        return res;
    }
}