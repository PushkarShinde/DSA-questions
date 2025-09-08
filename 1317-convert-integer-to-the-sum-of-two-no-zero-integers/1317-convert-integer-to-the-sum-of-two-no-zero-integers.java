class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<n;i++){
            if(nozero(i) && nozero(n-i)){
                return new int[]{i,n-i};
            }
        }
        return new int[]{0,n};
    }
    private boolean nozero(int a){
        while(a>0){
            if(a%10==0) return false;
            a/=10;
        }
        return true;
    }
}