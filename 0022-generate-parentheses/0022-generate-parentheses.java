class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        solve(n,n, "", ans); // start with prev = '0' to allow leading '1'
        return ans;
    }
    private static void solve(int open, int close, String num, List<String> ans){
        if(open==0 && close==0){
            ans.add(num);
            return;
        }
        if(open>0){
            solve(open-1, close, num+'(', ans);
        }
        if(close>open){
            solve(open, close-1, num+')', ans);
        }
    }
}