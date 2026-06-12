class Solution {
    public boolean kSubstr(String s, int k) {
        int n=s.length();
        if(n%k!=0) return false;
        String begin="";
        for(int i=0;i<k;i++){
            begin+=s.charAt(i);
        }
        String end="";
        for(int i=n-k;i<n;i++){
            end+=s.charAt(i);
        }
        
        int count=0;
        int i=k;
        while(i<n){
            if(s.charAt(i)!=begin.charAt(i%k)){
                count++;
                i+=k-(i%k);
                continue;
            }
            i++;
        }
        boolean beg=count<=1?true:false;
        
        count=0; 
        i=0;
        while(i<n-k){
            if(s.charAt(i)!=end.charAt(i%k)){
                count++;
                i+=k-(i%k);
                continue;
            }
            i++;
        }
        boolean en=count<=1?true:false;
        
        return beg || en;
    }
}