class Solution {
    public int climbStairs(int n) {
        if(n<2){
            return n;
        }
        int p1=0;
        int p2=1;
        int res=0;
        for(int i=1;i<=n;i++){
            res=p1+p2;
            p1=p2;
            p2=res;
        }
        return res;
    }
}