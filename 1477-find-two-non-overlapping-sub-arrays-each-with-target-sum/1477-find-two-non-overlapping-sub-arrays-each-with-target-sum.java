class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0,-1);
        
        int res=n+1;
        int minL=n;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(map.containsKey(sum-target)){
                int j=map.get(sum-target);
                int len=i-j;
                res=Math.min(res, len+(j==-1?n:arr[j]));
                minL=Math.min(minL, len);
            }

            arr[i]=minL;
            map.put(sum, i);
        }

        return res==n+1? -1: res;
    }
}