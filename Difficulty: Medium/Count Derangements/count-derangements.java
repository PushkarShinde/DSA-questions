class Solution {
    public int derangeCount(int n) {
        if(n==1) return 0;
        if(n==2) return 1;
        
        long pre2=0;
        long pre1=1;
        
        for(int i=3;i<=n;i++){
            long cur=(i-1)*(pre1+pre2);
            pre2=pre1;
            pre1=cur;
        }
        return (int)pre1;
    }
};