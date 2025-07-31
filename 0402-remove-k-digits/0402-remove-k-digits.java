class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        if(n==k) return "0";
        Stack<Integer> st=new Stack<>();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<n;i++){
            int c=num.charAt(i)-'0';
            while(!st.isEmpty() && k>0 && st.peek() > c){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(k>0) {
            st.pop();
            k--;
        }// in case the arr is sorted 

        while(!st.isEmpty()){
            str.append(st.pop());
        }
        str.reverse();

        return removeLeadingZeros(str);
    }
    private String removeLeadingZeros(StringBuilder str) {
        int i = 0;
        while (i < str.length() - 1 && str.charAt(i) == '0') {
            i++;
        }
    return str.substring(i); // returns a String, not StringBuilder
}
}