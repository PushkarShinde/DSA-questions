class Solution {
    public boolean isDigitorialPermutation(int n) {
        int m=n;
        int[] num=new int[10];
        long res=0;
        while(m>0){
            res+=fact(m%10);
            num[m%10]++;
            m/=10;
        }
        while(res>0){
            num[(int)res%10]--;
            res/=10;
        }
        for(int i:num){
            if(i!=0) return false;
        }
        return true;
    }
    private long fact(int n){
        if(n==0 || n==1) return 1;
        long  res=n;
        for(int i=n-1;i>1;i--){
            res*=(long)i;
        }
        return res;
    }
}