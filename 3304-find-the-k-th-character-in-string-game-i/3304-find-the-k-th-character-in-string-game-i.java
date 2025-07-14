class Solution {
    public char kthCharacter(int k) {
        StringBuilder str=new StringBuilder("a");
        solve(k, str);
        return str.charAt(k-1);
    }
    private void solve(int k, StringBuilder str){
        while(str.length()<k){
            StringBuilder newStr=new StringBuilder();
            for(char c: str.toString().toCharArray()){
                if(c=='z'){
                    newStr.append('a');
                }else{
                    newStr.append((char)(c+1));
                }
            }
            str.append(newStr);
        }
    }
}