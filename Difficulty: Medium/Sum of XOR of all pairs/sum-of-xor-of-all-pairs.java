class Solution {
    public long sumXOR(int[] arr) {
        long sum=0;
        int n=arr.length;
        /*
        BRUTE   
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                sum+=arr[i]^arr[j];
            }
        }
        return sum;
        */
        
        for(int b=0;b<20;b++){
            int one=0;
            int zero=0;
            for(int a:arr){
                if((a&(1<<b))!=0){
                    one++;
                }else{
                    zero++;
                }
            }
            long pairs=(long)one*zero;
            sum+=pairs*(1<<b);
        }
        
        return sum;
    }
}