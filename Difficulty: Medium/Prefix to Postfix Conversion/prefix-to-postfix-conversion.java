// User function Template for Java

class Solution {
    static boolean isOperator(char c){
        if(c=='+' || c=='-' || c=='*' || c=='/' || c=='%' || c=='^') return true;
        return false;
    }
    static String preToPost(String pre_exp) {
        int n=pre_exp.length();
        StringBuilder res=new StringBuilder();
        Stack<String> stack=new Stack();
        for(int i=n-1;i>=0;i--){
            char c=pre_exp.charAt(i);
            if(isOperator(c)){
                String op1= stack.pop();
                String op2= stack.pop();
                String str=op1+op2+c;
                stack.push(str);
            }else{
                stack.push(c+"");
            }
        }
        return stack.pop();
    }
}
