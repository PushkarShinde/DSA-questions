class Solution {
    public int getCount(int n) {
        int count=0;
        n=2*n;
        for(int k=2;k*(k+1)<=n;k++){
            if(n%k==0 && (n/k-k+1)%2==0) count++;
        }
        
        return count;
    }
};