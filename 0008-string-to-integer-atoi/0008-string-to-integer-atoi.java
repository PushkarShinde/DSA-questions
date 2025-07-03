class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length()==0) return 0;
        char sign=s.charAt(0);
        int pole=1;
        int index=0;
        if(sign=='-'){
            pole=-1;
            index++;
        } else if(sign=='+'){
            index++;
        }
        int res=0;
        int n=s.length();
        while(index<n && Character.isDigit(s.charAt(index))){
            int num=s.charAt(index)-'0';

            if(res>(Integer.MAX_VALUE -num)/10){
                return (pole==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            
            res=res*10+num;
            index++;
        }
        return res*pole;
    }
}