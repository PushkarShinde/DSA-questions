class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        boolean[] prime=new boolean[22];
        Arrays.fill(prime,true);
        prime[0]=prime[1]=false;
        for(int i=2;i*i<22;i++){
            if(prime[i]){
                for(int j=i*i;j<22;j+=i){
                    prime[j]=false;
                }
            }
        }
        for(int i=left;i<=right;i++){
            int setBit=Integer.bitCount(i);
            if(prime[setBit]) count++;
        }
        return count;
    }
}