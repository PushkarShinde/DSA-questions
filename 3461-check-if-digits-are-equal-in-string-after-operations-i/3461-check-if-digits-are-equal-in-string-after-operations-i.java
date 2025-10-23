class Solution {
    public boolean hasSameDigits(String s) {
        char[] ch=s.toCharArray();
        while(!same(ch) && ch.length>1){
            ch=solve(ch);
        }
        return ch.length>1;
    }
    private char[] solve(char[] ch){
        int n=ch.length;
        int[] num=new int[n];
        for(int i=0;i<n;i++){
            num[i]=ch[i]-'0';
        }
        char[] res=new char[n-1];
        for(int i=0;i<n-1;i++){
            res[i]=(char)((num[i]+num[i+1])%10);
        }
        return res;
    }
    private boolean same(char[] ch){
        for(int i=1;i<ch.length;i++){
            if(ch[i]!=ch[i-1]){
                return false;
            }
        }
        return true;
    }
}