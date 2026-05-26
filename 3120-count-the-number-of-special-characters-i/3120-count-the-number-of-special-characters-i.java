class Solution {
    public int numberOfSpecialChars(String word) {
        int cnt=0;
        Set<Character> set=new HashSet<>();
        boolean[] vis=new boolean[26];
        for(char c:word.toCharArray()){

            if(c>='a' && c<='z'){
                if(vis[c-'a']) continue;
                char big=(char)('A'+(c-'a'));
                if(set.contains(big)){
                    set.remove(big);
                    vis[big-'A']=true;
                    vis[c-'a']=true;
                    cnt++;
                    continue;
                }
            }
            if(c>='A' && c<='Z'){
                if(vis[c-'A']) continue;
                char small=(char)('a'+(c-'A'));
                if(set.contains(small)){
                    set.remove(small);
                    vis[small-'a']=true;
                    vis[c-'A']=true;
                    cnt++;
                    continue;
                }
            }

            set.add(c);
        }
        return cnt;
    }
}