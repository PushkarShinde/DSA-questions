class Solution {
    public String lexicographicallySmallest(String s, int k) {
        int n=s.length();
        k=((n&(n-1))==0)?k/2:k*2;
        if(k>=n) return "-1";
        
        Stack<Character> stack=new Stack<>();
        stack.push(s.charAt(0));
        for(int i=1;i<n;i++){
            char c=s.charAt(i);
            while(!stack.isEmpty() && stack.peek()>c && k>0){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        while(!stack.isEmpty() && k>0){
            stack.pop();
            k--;
        }
        
        StringBuilder res=new StringBuilder();
        while(!stack.isEmpty()){
            char c=stack.pop();
            res.append(c);
        }
        
        return res.reverse().toString();
    }
}