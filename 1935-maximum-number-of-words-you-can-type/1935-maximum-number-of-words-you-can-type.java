class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words=text.split(" ");
        Set<Character> broke=new HashSet<>();
        for(char c: brokenLetters.toCharArray()){
            broke.add(c);
        }
        int res=words.length;
        for(String w: words){
            for(char c: w.toCharArray()){
                if(broke.contains(c)){
                    res--;
                    break;
                }
            }
        }
        return res;
    }
}