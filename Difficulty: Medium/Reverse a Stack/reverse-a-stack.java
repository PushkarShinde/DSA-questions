// User function Template for Java

class Solution {
    static void reverse(Stack<Integer> s) {
        if(s.isEmpty()) return;
         /**
        We peel off the elements from the top of the stack, 
        go deep into recursion until the stack is empty, 
        and then insert the elements back from the bottom up, 
        which reverses the stack.
        */
        int top=s.pop();
        reverse(s); // sort the remaining items
        reverseInsert(s, top); // helper: inserts the popped element at the bottom of the stack
    }
    private static void reverseInsert(Stack<Integer> s, int element){
        if(s.isEmpty()){
            s.push(element);
            return;
        }
        int top=s.pop();
        reverseInsert(s,element); // go deeper to the bottom
        s.push(top);// put back all popped items
    }
}