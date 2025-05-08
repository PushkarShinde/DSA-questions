class Solution {
    public String freqAlphabets(String s) {
        StringBuilder res=new StringBuilder();
        int i=s.length()-1;
        while(i>=0){
            if(s.charAt(i)=='#'){
                int num=Integer.parseInt(s.substring(i-2,i));
                res.append((char)('a'+num-1));
                i-=3;
            }else{
                int num=s.charAt(i)-'0';
                res.append((char)('a'+num-1));
                i--;
            }
        }
        return res.reverse().toString();
    }
}
// wow