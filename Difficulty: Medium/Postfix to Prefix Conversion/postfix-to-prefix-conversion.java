// User function Template for Java

class Solution {
    static boolean isOperator(char c){
        if(c=='+' || c=='-' || c=='*' || c=='/' || c=='%' || c=='^') return true;
        return false;
    }
    static String postToPre(String post_exp) {
        int n=post_exp.length();
        StringBuilder res=new StringBuilder();
        Stack<String> stack=new Stack();
        for(int i=0;i<n;i++){
            char c=post_exp.charAt(i);
            if(isOperator(c)){
                String op1= stack.pop();
                String op2= stack.pop();
                String str=c+op2+op1;
                stack.push(str);
            }else{
                stack.push(c+"");
            }
        }
        return stack.pop();
    }
}
