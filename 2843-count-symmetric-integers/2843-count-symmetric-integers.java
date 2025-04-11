class Solution {
    public int countSymmetricIntegers(int low, int high) {
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
    }
}