class Solution {
    public int findPosition(int n) {
        int one=0;
        int pos=-1;
        for(int i=0;i<32;i++){
            if((n&(1<<i))!=0){
                pos=i+1;
                one++;
            }
            if(one>1) return -1;
        }
        return pos;
    }
}