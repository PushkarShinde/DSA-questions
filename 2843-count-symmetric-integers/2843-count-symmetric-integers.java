class Solution {
    public int countSymmetricIntegers(int low, int high) {
        /*
        BRUTE APPROACH.......TC- O(N^2)
        int count=0;
        for(int num=low;num<=high;num++){
            String s=String.valueOf(num);
            int n=s.length();
            if(n%2!=0) continue;
            int half=n/2;
            int sum1=0, sum2=0;
            for(int i=0;i<half;i++){
                sum1+=s.charAt(i)-'0';
                sum2+=s.charAt(i+half)-'0';
            }
            if(sum1==sum2) count++;
        }
        return count;
        */

        // OPTIMISED APPROACH...O(N)
        // we know constraints ke hisab se max is 10^4
        // so only even dig numbers are 10-99 and 1000-9999
        // so...
        int count=0;
        for(int num=low;num<=high;num++){
            if(num>=10 && num<=99){
                if(num%11==0) count++;
                // 10-99 has symmetric numbers div by 11..obviously!
            }else if(num>=1000 && num<=9999){
                int n1=(num/1000);
                int n2=(num/100)%10;
                int n3=(num/10)%10;
                int n4=(num)%10;
                if(n1+n2==n3+n4) count++;
            }
        }
        // wow!!
        return count;
    }
}