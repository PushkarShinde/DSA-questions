class Solution {
    public boolean hasSameDigits(String s) {
        char[] ch=s.toCharArray();
        while(ch.length>2){
            ch=solve(ch);
        }
        return same(ch);
    }
    private char[] solve(char[] ch){
        int n=ch.length;
        int[] num=new int[n];
        for(int i=0;i<n;i++){
            num[i]=(int)(ch[i]-'0');
        }
        char[] res=new char[n-1];
        for(int i=0;i<n-1;i++){
            res[i]=(char)(((num[i]+num[i+1])%10)+'0');
        }
        return res;
    }
    private boolean same(char[] ch){
        if(ch.length==1) return true;
        for(int i=0;i<ch.length-1;i++){
            if(ch[i]!=ch[i+1]){
                return false;
            }
        }
        return true;
    }
}