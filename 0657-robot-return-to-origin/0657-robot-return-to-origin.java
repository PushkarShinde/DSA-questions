class Solution {
    public boolean judgeCircle(String moves) {
        int up=0;
        int left=0;
        for(char c:moves.toCharArray()){
            if(c=='U') up++;
            if(c=='D') up--;
            if(c=='L') left++;
            if(c=='R') left--;
        }

        return up==0 && left==0;
    }
}