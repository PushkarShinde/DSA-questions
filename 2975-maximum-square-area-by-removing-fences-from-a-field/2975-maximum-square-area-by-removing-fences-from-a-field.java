class Solution {
    private final int mod=(int)(1e9+7);
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        if(n==m) return (n-1)*(m-1);
        //Agar mere pass x width hai toh kya mere pass x heigth bhi hai?
        Set<Integer> vertical=getSides(vFences, n); 
        Set<Integer> horizontal=getSides(hFences, m); 
        long res=0;
        for(int v:vertical){
            if(horizontal.contains(v)){
                res=Math.max(res,v);
            }
        }
        if(res==0){
            return -1;
        }
        return (int)((res*res)%mod);
    }
    private Set<Integer> getSides(int[] a, int n){
        Set<Integer> sides=new HashSet<>(); 
        List<Integer> list=new ArrayList<>();
        for(int i:a){
            list.add(i);
        }
        list.add(1);
        list.add(n);
        Collections.sort(list);
        n=list.size();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                sides.add(list.get(j)-list.get(i));//sides
            }
        }
        return sides;
    }
}