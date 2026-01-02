class Solution {
    //This is a DFS + memoization problem on strings.
    private Set<String> memo=new HashSet<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        int n=allowed.size();
        int m=bottom.length();
        Map<String, List<Character>> map=new HashMap<>();
        for (String a :allowed){
            String s=a.substring(0,2);
            map.computeIfAbsent(s,k-> new ArrayList<>()).add(a.charAt(2));
        }
        return dfs(map, bottom);
    }
    private boolean dfs(Map<String, List<Character>> map, String base){
        if(base.length()==1) return true;
        if(memo.contains(base)) return false;
        List<String> nextLevel=new ArrayList<>();
        buildNext(map,  0, new StringBuilder(), base, nextLevel);
        for(String s: nextLevel){
            if(dfs(map,s)) return true;
        }
        memo.add(base);//if didn't work
        return false;
    }
    private void buildNext(Map<String, List<Character>> map, int idx, StringBuilder sb, String base, List<String> ans){
        if(idx==base.length()-1){
            ans.add(sb.toString());
            return;
        }
        String key=base.substring(idx,idx+2);
        if(!map.containsKey(key)) return;
        for(char c:map.get(key)){
            sb.append(c);
            buildNext(map,idx+1,sb,base,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}