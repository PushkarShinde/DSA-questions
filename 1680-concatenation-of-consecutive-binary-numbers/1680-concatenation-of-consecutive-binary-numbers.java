class Solution {
    private int mod=(int)1e9+7;
    public int concatenatedBinary(int n) {
        int bits=0;
        long pre=0;
        for(int i=1;i<=n;i++){
            if((i&(i-1))==0) bits++;
            pre=((pre<<bits)+i)%mod;
        }
        return (int)pre;
    }
}