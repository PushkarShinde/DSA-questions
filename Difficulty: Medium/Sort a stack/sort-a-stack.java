/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        /**
        Recursively pop all elements until the stack is empty.
        Then, insert the popped elements back in sorted order using a helper function sortedInsert().
        */
        if(!s.isEmpty()){
            int top=s.pop();
            sort(s); // sort the remaining items
            sortedInsert(s, top); //helper, insert the popped element in sorted order
        }
        return s;
    }
    private void sortedInsert(Stack<Integer> s, int element){
        if(s.isEmpty() || element>=s.peek()){
            s.push(element);
            return;
        }
        int top=s.pop();
        sortedInsert(s,element); // take the smaller element below
        s.push(top);
    }
}