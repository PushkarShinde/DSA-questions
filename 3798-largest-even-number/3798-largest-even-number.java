class Solution {
    public String largestEven(String s) {
        StringBuilder res=new StringBuilder(s);
        int i=s.length()-1;
        while(!res.isEmpty() && res.charAt(i)=='1'){
            res.deleteCharAt(i);
            i--;
        }
        return res.toString();
    }
}