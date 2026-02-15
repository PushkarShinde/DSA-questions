class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>();
        Set<Character> set=new HashSet<>();
        for(char c:expression.toCharArray()){
            if(c==',') continue;
            if(c==')'){
                while(true){
                    if(st.peek()=='(') {
                        st.pop();
                        break;
                    }
                    set.add(st.pop());
                }
                char op=st.pop();
                if(set.size()==2){
                    if(op=='|'){
                        st.push('t');
                    }else if(op=='&'){
                        st.push('f');
                    }
                }else{
                    if(op=='!'){    
                        if(set.contains('t')){
                            st.push('f');
                        }else {
                            st.push('t');
                        }
                    }else{
                        if(set.contains('t'))st.push('t');
                        else st.push('f');
                    }
                }
                set.clear();
            }else{
                st.push(c);
            }
        }
        return st.pop()=='t';
    }
}