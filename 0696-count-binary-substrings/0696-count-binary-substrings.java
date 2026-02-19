class Solution {
    public int countBinarySubstrings(String s) {
        int n=s.length();
        int pre=0;
        int cur=0;
        int res=0;
        char preChar=s.charAt(0);
        for(int i=0;i<n;i++){
            char curChar=s.charAt(i);
            if(preChar==curChar) cur++;
            else{
                res+=Math.min(pre,cur);
                pre=cur;
                cur=1;
            }
            preChar=curChar;
        }
        res+=Math.min(cur,pre);
        return res;
    }
}