class Solution {
public:
    int climbStairs(int n) {
        if(n==1) return 1;
        int p1=1, p2=2;
        int sum;
        for(int i=3;i<=n;i++){
            sum=p1+p2;
            p1=p2;
            p2=sum;
        }   
        return p2;
    }
};