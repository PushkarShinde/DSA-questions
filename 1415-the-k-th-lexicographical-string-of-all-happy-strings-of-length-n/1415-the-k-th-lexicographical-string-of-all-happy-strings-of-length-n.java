class Solution {
    char[] ch={'a','b','c'};
    List<String> res=new ArrayList<>();
    int n;
    public String getHappyString(int n, int k) {
        this.n=n;

        for(char c:ch){
            StringBuilder sb=new StringBuilder();
            sb.append(c);
            solve(sb);
        }
        
        if(k>res.size()) return ""; 
        return res.get(k-1);
    }

    private void solve(StringBuilder cur){
        if(cur.length()==n){
            res.add(cur.toString());
            return;
        }
        char pre=cur.charAt(cur.length()-1);
        for(char c:ch){
            if(pre!=c){
                cur.append(c);
                solve(cur);
                cur.deleteCharAt(cur.length()-1);
            }
        }
    }
}