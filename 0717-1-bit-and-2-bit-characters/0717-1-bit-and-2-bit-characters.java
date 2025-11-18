class Solution{
    public boolean isOneBitCharacter(int[] bits){
        int n=bits.length;
        int i=0;
        while(i<n){
            if(i==n-1) return true;
            if(bits[i]==1){
                i+=2;
            }else{
                i++;
            }
        }
        return false;
    }
}