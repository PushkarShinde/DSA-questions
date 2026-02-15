class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res=new StringBuilder();
        int n=a.length(), m=b.length();
        int l=n-1, r=m-1;
        boolean rem=false;
        while(l>=0 && r>=0){
            if(a.charAt(l)=='1' && b.charAt(r)=='1'){
                if(rem)res.append('1');
                else res.append('0');
                rem=true;
            }else if(a.charAt(l)=='0' && b.charAt(r)=='1' || a.charAt(l)=='1' && b.charAt(r)=='0'){
                if(rem) {
                    res.append('0');
                    // rem=true;
                }else{
                    res.append('1');
                }
            }else if(a.charAt(l)=='0' && b.charAt(r)=='0'){
                if(rem) {
                    res.append('1');
                    rem=false;
                }else res.append('0');
            }
            l--; r--;
        }
        while(l>=0){
            if(a.charAt(l)=='1'){
                if(rem) res.append('0');
                else res.append('1');
            }else if(a.charAt(l)=='0'){
                if(rem) {
                    res.append('1');
                    rem=false;
                }
                else res.append('0');
            }
            l--;
        }
        while(r>=0){
            if(b.charAt(r)=='1'){
                if(rem) res.append('0');
                else res.append('1');
            }else if(b.charAt(r)=='0'){
                if(rem) {
                    res.append('1');
                    rem=false;
                }
                else res.append('0');
            }
            r--;
        }
        if(rem) res.append('1');
        return res.reverse().toString();
    }
}