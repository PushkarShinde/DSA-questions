class Solution {
    public char processStr(String s, long k) {
        int n=s.length();
        
        long len=0;
        long[] l=new long[n];

        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='#'){
                len*=2;
            }else if(c=='*'){
                len=Math.max(0,len-1);
            }else if(c=='%'){
                // continue;
            }else{
                len++;
            }
            l[i]=len;
        }

        if(len==0 || k>=len) return '.';

        for(int i=n-1;i>=0;i--){
            char c=s.charAt(i);
            long pre=(i>0)?l[i-1]:0L;

            if(c=='#'){
                // len/=2;
                // if(len<=k) k-=len;
                if(pre!=0) k%=pre;
            }else if(c=='*'){
                // len++;
            }else if(c=='%'){
                k=pre-1-k;
            }else{
                if(pre==k){
                    return c;
                } 
            }
        }

        return '.';
    }
}