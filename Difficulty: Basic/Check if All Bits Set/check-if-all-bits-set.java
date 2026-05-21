class Solution {
    public boolean isBitSet(int n) {
        for(int i=1;i<20;i++){
            if((1<<i)-1==n) return true;
        }
        return false;
    }
};