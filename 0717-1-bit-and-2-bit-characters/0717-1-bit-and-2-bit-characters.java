class Solution{
    public boolean isOneBitCharacter(int[] bits){
        int n=bits.length;
        if(n%2==0 && bits[n-2]==1) return false;
        for(int i=n-2;i>0;i--){
            if(bits[i-1]!=1) return false;
        }
        return true;
    }
}