class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {
        int n=seats.length;
        if(n==1 && seats[n-1]==0) return true;
        int i=0;
        while(i<n){
            if(seats[i]==0 && (i==0 || seats[i-1]==0) && (i==n-1 || seats[i+1]==0)){
                seats[i]=1;
                k--;
                i++;
            }
            if(k<=0) return true;
            i++;
        }
        
        return false;
    }
}