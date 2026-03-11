class Solution {
    public int bitwiseComplement(int n) {
        String s=Integer.toBinaryString(n);
        StringBuilder res=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='0') res.append('1');
            else res.append('0');
        }
        return Integer.parseInt(res.toString(), 2);
    }
}