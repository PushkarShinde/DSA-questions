class Solution {
    public boolean isBinaryPalindrome(int n) {
        String bin=Integer.toBinaryString(n);
        int m=bin.length();
        int i=0;
        while(i<m){
            if(bin.charAt(i)!='0') break;
            i++;
        }
        int ind=0;
        for(;i<m;i++){
            if(bin.charAt(i)!=bin.charAt(m-ind-1)) return false;
            ind++;
        }
        return true;
    }
};