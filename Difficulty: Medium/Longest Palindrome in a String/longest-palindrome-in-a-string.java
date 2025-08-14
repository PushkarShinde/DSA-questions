
class Solution {
    static String longestPalindrome(String s) {
        if(s==null) return "";
        int start=0, end=0;
        int bestS=0, maxlen=0;
        for(int i=0;i<s.length();i++){
            int pal1=expandFromCenter(s, i, i);//odd length ke liye
            int pal2=expandFromCenter(s, i, i+1);//even length ke liye
            int len=Math.max(pal1, pal2);
            
            int currStart = i - (len - 1) / 2;
            if (len > maxlen || (len == maxlen && currStart < bestS)) {
                start = currStart;
                end = i + (len / 2);
                maxlen = len;
                bestS = start;
            }

        }
        return s.substring(start,end+1);
    }
    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome
    }
}