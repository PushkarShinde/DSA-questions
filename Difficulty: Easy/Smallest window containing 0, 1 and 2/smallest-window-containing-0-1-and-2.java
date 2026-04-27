class Solution {
    public int smallestSubstring(String s) {
        int l=0;
        int n=s.length();
        int minLen=Integer.MAX_VALUE;
        int one=0, two=0, zero=0;
        for(int r=0;r<n;r++){
            char c=s.charAt(r);
            if(c=='0'){
                zero++;
            }else if(c=='1'){
                one++;
            }else {
                two++;
            }
            while(l<n && zero>0 && two>0 && one>0){
                minLen=Math.min(minLen, zero+one+two);
                char ch=s.charAt(l);
                if(ch=='0'){
                    zero--;
                }else if(ch=='1'){
                    one--;
                }else {
                    two--;
                }
                l++;
            }
        }
        
        return minLen==Integer.MAX_VALUE?-1:minLen;
    }
};
