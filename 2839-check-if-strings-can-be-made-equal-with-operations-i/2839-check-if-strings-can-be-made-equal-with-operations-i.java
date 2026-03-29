class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        for(int i=0;i<4;i++){
            char a=s1.charAt(i);
            char b1=s2.charAt(i);
            char b2=s2.charAt((i+2)%4);

            if(a!=b1 && a!=b2) return false;
        }
        return true;
    }
}