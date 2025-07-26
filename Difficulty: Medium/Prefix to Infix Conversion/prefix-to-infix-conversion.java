// User function Template for Java

class Solution {
    static boolean isOperator(char c){
        if(c=='+' || c=='-' || c=='*' || c=='/' || c=='%' || c=='^') return true;
        return false;
    }
    static String preToInfix(String pre_exp) {
        // code here
        int n=pre_exp.length();
        StringBuilder res=new StringBuilder();
        Stack<String> stack=new Stack();
        for(int i=n-1;i>=0;i--){
            char c=pre_exp.charAt(i);
            if(isOperator(c)){
                String op1= stack.pop();
                String op2= stack.pop();
                String str="("+ op1 +c+op2+")";
                stack.push(str);
            }else{
                stack.push(c+"");
            }
        }
        return stack.pop();
    }
}
