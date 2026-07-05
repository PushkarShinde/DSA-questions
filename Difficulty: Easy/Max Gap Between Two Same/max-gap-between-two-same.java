class Solution {
    public int maxCharGap(String s) {
        int res=-1;
        int n=s.length();
        Map<Character, List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            map.computeIfAbsent(c, k->new ArrayList<>()).add(i);
        }
        for(List<Integer> list: map.values()){
            res=Math.max(res, list.get(list.size()-1)-1-list.get(0));
        }
        return res;
    }
};