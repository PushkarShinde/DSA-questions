class Solution {
    public String decodeAtIndex(String s, int k) {
        int n=s.length();
        long total=0;
        for(char c:s.toCharArray()){
            if(c<='9' && c>='2') total=total*(c-'0');
            else total++;
        }

        for(int i=n-1;i>=0;i--){
            char c=s.charAt(i);
            k%=total;

            if(k==0 && Character.isLetter(c)) return String.valueOf(c);

            if(Character.isDigit(c)) {
                total=total/(c-'0');
            }else{
                total--;
            }
        }

        return "";
    }
}