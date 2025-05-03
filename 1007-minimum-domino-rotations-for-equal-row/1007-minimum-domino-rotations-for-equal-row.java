class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n=tops.length;
        for(int j=1;j<6;j++){
            int tcount=0;
            int bcount=0;
            boolean valid=true;
            for(int i=0;i<n;i++){
                if(tops[i]!=j && bottoms[i]!=j) {
                    valid=false;
                    break;
                }else if(tops[i]==j && bottoms[i]==j){
                    continue;
                }else if(tops[i]!=j){
                    tcount++;
                }else if(bottoms[i]!=j){
                    bcount++;
                }
            }
            if(valid) return Math.min(tcount,bcount);
        }
        return -1;
    }
}