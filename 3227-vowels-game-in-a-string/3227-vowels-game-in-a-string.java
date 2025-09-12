class Solution {
    public boolean doesAliceWin(String s) {
        Set<Character> vovel=new HashSet<>();
        vovel.add('a');
        vovel.add('e');
        vovel.add('i');
        vovel.add('o');
        vovel.add('u');
        int v=0;
        for(char c: s.toCharArray()){
            if(vovel.contains(c)) v++;
        }
        if(v==0) return false;
        if(v==1) return true;
        return v%2==0;
    }
}