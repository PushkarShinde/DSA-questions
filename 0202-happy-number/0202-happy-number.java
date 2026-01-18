class Solution {
    public boolean isHappy(int m) {
        int fast=m;
        int slow=m;
        do{
            fast=solve(fast);
            fast=solve(fast);
            slow=solve(slow);
        }while(fast!=slow);
        return slow==1;
    }
    private int solve(int n){//10
        int sum=0;
        while(n>0){
            int d=n%10;
            sum+=d*d;
            n/=10;
        }
        return sum;
    }
}