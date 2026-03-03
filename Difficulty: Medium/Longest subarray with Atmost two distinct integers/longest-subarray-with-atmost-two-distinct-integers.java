class Solution {
    public int totalElements(int[] arr) {
        Map<Integer, Integer> map=new HashMap<>();
        int l=0;
        int n=arr.length;
        int res=0;
        for(int r=0;r<n;r++){
            map.put(arr[r], map.getOrDefault(arr[r],0)+1);
            if(map.size()<=2) res=Math.max(res, r-l+1);
            while(map.size()>2){
                if(map.get(arr[l])==1) map.remove(arr[l]);
                else map.put(arr[l], map.get(arr[l])-1);
                l++;
            }
        }
        return res;
    }
}