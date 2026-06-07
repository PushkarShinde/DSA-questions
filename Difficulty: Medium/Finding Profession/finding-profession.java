class Solution {
    public String profession(int level, int pos) {
        // int flip=0;
        // while(pos>1){
        //     if((pos&1)!=1) flip++;
        //     pos/=2;
        // }
        // return ((flip&1)!=1)?"Engineer":"Doctor";
        return (Integer.bitCount(pos-1)&1)==0?"Engineer":"Doctor";
    }
}