class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        Set<Integer> set=new HashSet<>();
        for(int i:a){
            set.add(i);
        }
        for(int i:b){
            set.add(i);
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int i:set){
            res.add(i);
        }
        return res;
    }
}