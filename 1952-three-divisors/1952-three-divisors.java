class Solution {
    public int divisors(int n){
        int count=0;
        for(int i=1;i<=n;i++){
            if(n%i==0) count++;
        }
        return count;
    }
    public boolean isThree(int n) {
        if(divisors(n)==3){
            return true;
        }
        return false;
    }
}