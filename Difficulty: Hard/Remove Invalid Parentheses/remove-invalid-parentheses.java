class Solution {
    Set<String> set;
    
    public List<String> validParenthesis(String s) {
        set=new TreeSet<>();
        int open=0, close=0;
        
        for(char c:s.toCharArray()){
            if(c!='(' && c!=')') continue;
            if(c=='('){
                open++;
            }else{
                if(open>0){
                    open--;
                }else{
                    close++;
                }
            }
        }

        solve(s, open, close, 0);
        
        return new ArrayList<>(set);
    }
    
    private void solve(String s, int open, int close, int i){
        if(open==0 && close==0){
            if(valid(s)) set.add(s);
            return;
        }
        
        if(i>=s.length()) return;
        
        char c=s.charAt(i);
        solve(s, open, close, i+1);
        
        if(c=='(' && open>0){
            String next=s.substring(0,i)+s.substring(i+1);
            solve(next,open-1, close, i);
        }else if(c==')' && close>0){
            String next=s.substring(0,i)+s.substring(i+1);
            solve(next, open, close-1, i);
        }
    }
    
    private boolean valid(String s){
        int bal=0;
        for(char c:s.toCharArray()){
            if(c=='(') bal++;
            else if(c==')'){
                if(bal==0) {
                    return false;
                }
                bal--;
            }
        }
        return true;
    }
}
