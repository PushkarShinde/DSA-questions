class Solution {
    public int almostPalindromic(String s) {
        int n=s.length();
        int res=2;
        for(int c=0;c<n;c++){
            //odd len
            int len=1;
            boolean skip=true;
            for(int j=c-1, k=c+1;j>=0 || k<n;j--, k++){
                if(j>=0 && k<n && s.charAt(j)==s.charAt(k)) len+=2;
                else if(skip) {
                    k--;len++; skip=false;//skip left
                }
                else break;
            }
            res=Math.max(res, len);
            len=1; skip=true;
            for(int j=c-1, k=c+1;j>=0 || k<n;j--, k++){
                if(j>=0 && k<n && s.charAt(j)==s.charAt(k)) len+=2;
                else if(skip) {
                    j++;len++; skip=false;//skip right
                }
                else break;
            }
            res=Math.max(res, len);

            //even len
            len=0; skip=true;
            for(int j=c, k=c+1;j>=0 || k<n;j--, k++){
                if(j>=0 && k<n && s.charAt(j)==s.charAt(k)) len+=2;
                else if(skip) {
                    k--;len++; skip=false;//skip right
                }
                else break;
            }
            res=Math.max(res, len);
            len=0; skip=true;
            for(int j=c, k=c+1;j>=0 || k<n;j--, k++){
                if(j>=0 && k<n && s.charAt(j)==s.charAt(k)) len+=2;
                else if(skip) {
                    j++;len++; skip=false;//skip right
                }
                else break;
            }
            res=Math.max(res, len);
        }
        return res;
    }
}