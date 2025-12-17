class Solution {
    public int climbStairs(int n) {
        if(n<2){
            return n;
        }
        int p1=0;
        int p2=1;
        // int res=0;
        for(int i=1;i<=n;i++){
            int temp=p1+p2;
            p1=p2;
            p2=temp;
        }
        return p2;
    }
}