class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        Map<Integer, Integer> map=new HashMap<>();
        int[] res=new int[n];
        
        for(int i=0;i<n;i++){
            int a=A[i];
            int b=B[i];
            map.put(a, map.getOrDefault(a,0)+1);
            map.put(b, map.getOrDefault(b,0)+1);

            int count=0;
            for(int key:map.keySet()){
                int val=map.get(key);
                if(val==2) count++;
            }

            res[i]=count;
        }
        return res;
    }
}