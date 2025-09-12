class Solution {
    public boolean doesAliceWin(String s) {
        // Set<Character> vovel=new HashSet<>();
        // vovel.add('a');
        // vovel.add('e');
        // vovel.add('i');
        // vovel.add('o');
        // vovel.add('u');
        int v=0;
        for(char c: s.toCharArray()){
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
                v++;
                break;
            }
        }
        if(v==0) return false;
        // if(v%) return true;
        return true;
    }
}