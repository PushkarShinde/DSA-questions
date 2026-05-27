class Solution {
    public boolean wifiRange(String s, int x) {
        int n=s.length();
        int one=-1, two=-1;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                two=i;
                if(one==-1 && two>x) return false;
                if(two-one>2*x+1) return false;
                one=two;
            }
        }
        return one!=-1 && (n-1-two<=x);
    }
}