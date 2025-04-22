class Solution {
    public int lengthOfLastWord(String s) {
        int sp=0;
        int st=s.length()-1;
        for(int i=s.length()-1; i>=0;i--){
            if(s.charAt(i)==' ') st--;
            else break;
        }
        for(int i=st; i>=0;i--){
            if(s.charAt(i)==' ') return sp;
            sp++;
        }
        return sp;
    }
    /**
        public int lengthOfLastWord(String s) {
        s=s.trim();
        String[] words=s.split(" ");
        return words[words.length-1].length();
    } */
}