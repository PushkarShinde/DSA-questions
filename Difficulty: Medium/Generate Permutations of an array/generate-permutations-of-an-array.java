class Solution {
    private static ArrayList<ArrayList<Integer>> res;
    //BITMASKINNG!!!
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        int n=arr.length;
        res=new ArrayList<>();
        bitmask(arr, 0, new ArrayList<>());
        return res;
    }
    private static void bitmask(int[] a, int mask, List<Integer> cur){
        int n=a.length;
        if(cur.size()==n){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0;i<n;i++){
            if((mask & (1<<i))!=0) continue;
            cur.add(a[i]);
            bitmask(a, mask | (1<<i), cur);
            cur.remove(cur.size()-1);
        }
    } 
};