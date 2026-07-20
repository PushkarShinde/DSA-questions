class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        dfs(0, s, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int start, String s, List<String> cur,  List<List<String>> res){
        if(start==s.length()){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int end=start;end<s.length();end++){
            if(palindrome(s,start, end)){
                cur.add(s.substring(start, end+1));

                dfs(end+1, s, cur, res);

                cur.remove(cur.size()-1);
            }
        }
    }

    private boolean palindrome(String s, int i,int j){
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++; j--;
            }else{
                return false;
            }
        }
        return true;
    }
}