class Solution {
    public boolean checkOnesSegment(String s) {
        int n=s.length();
        int ones=0;
        if(s.charAt(0)=='1') ones++;
        for(int i=1;i<n;i++){
            if(s.charAt(i)=='1'){
                if(s.charAt(i-1)=='1') continue;
                ones++;
            }
        }
        return ones<=1;
    }
}