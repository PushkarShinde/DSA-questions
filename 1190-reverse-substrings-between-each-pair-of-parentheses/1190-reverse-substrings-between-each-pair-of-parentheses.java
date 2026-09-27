class Solution {
    public String reverseParentheses(String s) {
        int n=s.length();
        Stack<Character> stack=new Stack<>();
        
        for(char c:s.toCharArray()){
            if(c==')'){
                StringBuilder mid=new StringBuilder();
                while(!stack.isEmpty() && stack.peek()!='('){
                    mid.append(stack.pop());
                }

                stack.pop();

                for(char ch: mid.toString().toCharArray()){
                    stack.push(ch);
                }
            }else{
                stack.push(c);
            }
        }

        StringBuilder res=new StringBuilder();

        while(!stack.isEmpty()){
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}