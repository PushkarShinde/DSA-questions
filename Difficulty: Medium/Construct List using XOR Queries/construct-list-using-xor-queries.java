class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        int n=0;
        List<Integer> a=new ArrayList<>();
        a.add(0);
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int[] q:queries){
            if(q[0]==0){
                a.add(q[1]);
                n++;
            }else{
                map.computeIfAbsent(n, k-> new ArrayList<>()).add(q[1]);
            }
        }
        
        int[] xor=new int[n+1];
        if(map.containsKey(n)){
            for(int v:map.get(n)){
                xor[n]=v^xor[n];
            }
        }
        for(int i=n-1;i>=0;i--){
            if(map.containsKey(i)){
                for(int v:map.get(i)){
                    xor[i]=v^xor[i];
                }
                xor[i]^=xor[i+1];
            }else{
                xor[i]=xor[i+1];
            }
        }
        
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<=n;i++){
            res.add(a.get(i)^xor[i]);
        }
        
        Collections.sort(res);
        return res;
    }
}