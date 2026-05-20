class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        Map<Integer, Integer> map=new HashMap<>();
        int[] res=new int[n];

        int count=0;
        for(int i=0;i<n;i++){
            int a=A[i];
            int b=B[i];
            map.put(a, map.getOrDefault(a,0)+1);
            map.put(b, map.getOrDefault(b,0)+1);
            
            int valA=map.get(a);
            int valB=map.get(b);
            if(valA==2) count++;
            if(a!=b && valB==2) count++;

            res[i]=count;
        }
        return res;
    }
}