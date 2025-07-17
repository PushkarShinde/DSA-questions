class Solution {
    public int hammingWeight(int n) {
        int count=0;
        long i=1;
        while(i<=n){
            if((n&i)!=0) count++;
            i<<=1;
        }
        return count;
    }
}