class Solution {
    List<String> res;
    int n;
    public List<String> generateParenthesis(int n) {
        this.n=n;
        res=new ArrayList<>();
        solve(n,n, new StringBuilder());
        return res;
    }
    private void solve(int open, int close, StringBuilder per){
        if(open==0 && close==0 && per.length()==2*n){
            res.add(per.toString());
            return;
        }
        if(open>0){
            per.append('(');
            solve(open-1, close, per);
            per.deleteCharAt(per.length()-1);
        }
        if(close>0 && open<close){
            per.append(')');
            solve(open, close-1, per);
            per.deleteCharAt(per.length()-1);
        }
    }
}