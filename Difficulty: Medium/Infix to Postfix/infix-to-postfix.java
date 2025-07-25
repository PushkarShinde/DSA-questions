class Solution {
    private static int prio(char c){
        if(c=='^') return 3;
        else if(c=='*' || c=='/') return 2;
        else if(c=='+' || c=='-') return 1;
        else return -1;
    }
    
    public static String infixToPostfix(String s) {
        StringBuilder res=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for(char c: s.toCharArray()){
            // agar operand h toh add kar diya string me
            if(Character.isLetterOrDigit(c)){
                res.append(c);
            }else if(c=='(') {
                stack.push(c);
            }else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    res.append(stack.pop());
                }
                stack.pop(); // '(' hata diya
            }else{//agar operator hai
                while(!stack.isEmpty() && prio(stack.peek())>=prio(c)){
                    res.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }
}