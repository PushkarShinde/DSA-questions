class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int numL=0;
        for(char c:moves.toCharArray()){
            if(c=='L') numL--;
            else numL++;
        }

        int numR=0;
        for(char c:moves.toCharArray()){
            if(c=='R') numR--;
            else numR++;
        }

        return Math.max(numL, numR);
    }
}