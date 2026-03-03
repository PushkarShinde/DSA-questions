class Solution {
    public char findKthBit(int n, int k) {
        String s="0";
        for(int i=1;i<=n;i++){
            if(s.length()>k) break;
            String str=s+"1"+reverse(inverse(s));
            s=str;
        }
        return s.charAt(k-1);
    }
    private String reverse(char[] ch){
        int n=ch.length;
        for(int i=0;i<n/2;i++){
            char temp=ch[i];
            ch[i]=ch[n-1-i];
            ch[n-1-i]=temp;
        }
        StringBuilder res=new StringBuilder();
        for(char c:ch){
            res.append(c);
        }
        return res.toString();
    }
    private char[] inverse(String s){
        char[] ch=s.toCharArray();
        int n=ch.length;
        for(int i=0;i<n;i++){
            if(ch[i]=='1') ch[i]='0';
            else ch[i]='1';
        }
        return ch;
    }
}