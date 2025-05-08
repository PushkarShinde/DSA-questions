class Solution {
    public String freqAlphabets(String s) {
        StringBuilder res=new StringBuilder();
        int i=s.length()-1;
        while(i>=0){
            if(s.charAt(i)=='#'){
                // int num=Integer.parseInt(s.substring(i-2,i));
                int num=(s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0'); 
                // instead of using substring method that taking alot of overhead, 
                //we directly derived the number using our good'ol way!! :)
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