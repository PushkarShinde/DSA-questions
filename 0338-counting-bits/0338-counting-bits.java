class Solution {
    public int[] countBits(int n) {
        int[] num=new int[n+1];
        for(int i=0;i<n+1;i++){
            num[i]=solve(i);
        }
        return num;
    }
    private int solve(int n){
        int count=0;
        int i=1;
        while(i<=n){
            if((n&i)!=0) count++;
            i<<=1;
        }
        return count;
    }
}