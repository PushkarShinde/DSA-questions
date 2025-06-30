class Solution {
    public String removeOuterParentheses(String s) {
        int n=s.length();
        StringBuilder str=new StringBuilder();
        int depth=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                if(depth>0){
                    str.append(c);
                }
                depth++;
            }else if(c==')'){
                if(depth>1){
                    str.append(c);
                }
                depth--;
            }
        }
        return str.toString();
    }
}