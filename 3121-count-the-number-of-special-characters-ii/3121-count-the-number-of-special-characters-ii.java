class Solution {
    public int numberOfSpecialChars(String word) {
        int cnt=0;
        int n=word.length();
        Map<Character, Integer> mapS=new HashMap<>();
        Map<Character, Integer> mapB=new HashMap<>();
        for(int i=0;i<n;i++){
            char c=word.charAt(i);
            if(c>='a' && c<='z'){
                mapS.put(c, i);
            }
            if(c>='A' && c<='Z'){
                if(mapB.containsKey(c)) continue;
                mapB.put(c, i);
            }
        }
        for(char c:mapB.keySet()){
            char small=(char)('a'+(c-'A'));
            if(!mapS.containsKey(small)) continue;
            int indS=mapS.get(small);
            int indB=mapB.get(c);
            if(indS<indB) cnt++;
        }
        return cnt;
    }
}