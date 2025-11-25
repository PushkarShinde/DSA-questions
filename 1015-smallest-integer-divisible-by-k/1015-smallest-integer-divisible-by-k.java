class Solution {
    public int smallestRepunitDivByK(int k) {
        int n=0;
        int count=0;
        while(count<100000){
            n=((n*10)+1)%k;
            count++;
            if(n==0) return count;
        }
        return -1;
    }
}