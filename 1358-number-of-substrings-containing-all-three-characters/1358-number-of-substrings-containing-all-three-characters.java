class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int res=0;

        int l=0;
        int[] f=new int[3];
        for(int r=0;r<n;r++){
            char ch=s.charAt(r);
            f[ch-'a']++;
            int len=n-r;
            if(!(f[0]>0 && f[1]>0 && f[2]>0)) continue;
               
            while(l<r && f[s.charAt(l)-'a']>0){
                f[s.charAt(l)-'a']--;
                l++;
                res+=len;
                if(!(f[0]>0 && f[1]>0 && f[2]>0)) break;
            }
        }

        return res;
    }
}