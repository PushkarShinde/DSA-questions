class Solution {
    public boolean isPowerOfThree(int n) {
        // boolean isNum=false;
    //     if(n==1) return true;
    //     int sum=0;
        int m=n;
    //     while(m>0){
    //         sum+=m%10;
    //         m/=10;
    //     }
    //     if(sum%3!=0) return false;
    //     int three=3;
    //     if(n<0) return false;
    //     while(three<Integer.MAX_VALUE){
    //         if(three>n) return false;
    //         if(three==n) return true;
    //         three*=3;
    //     }
    //     return false;
    // }

        if(n<1) return false;
        while(m%3==0) m/=3;
        return m==1;
    }
}