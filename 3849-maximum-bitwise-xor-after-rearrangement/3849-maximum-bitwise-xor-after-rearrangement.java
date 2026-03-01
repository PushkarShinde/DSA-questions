class Solution {
    public String maximumXor(String s, String t) {
        int n=s.length();
        int ones=0;
        int onet=0;
        for(int i=0;i<n;i++){
            // if(s.charAt(i)=='1') ones++;
            if(t.charAt(i)=='1') onet++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1') sb.append('1');
            else {
                if(onet>0){
                    sb.append('1');
                    onet--;
                }
                else sb.append('0');
            }
        }
        int i=n-1;
        while(onet>0 && i>=0){
            if(s.charAt(i)=='1'){
                onet--;
                sb.setCharAt(i,'0');
            }
            i--;
        }
        return sb.toString();
    }
}