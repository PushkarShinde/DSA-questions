class MinStack {

    private class Node{
        int data;
        Node next;
        int min;
        Node(int data, int min, Node next){
            this.data=data;
            this.min=min;
            this.next=next;
        }
    }

    private Node top;
    public MinStack(){
        top=null;
    }
    
    public void push(int val) {
        if(top==null){
            top=new Node(val, val, null);
        }else{
            int currMin=Math.min(val, top.min);
            Node newNode=new Node(val, currMin, top);
            top=newNode;
        }
    }
    
    public void pop() {
        if(top!=null){
            top=top.next;
        }
    }
    
    public int top() {
        if(top!=null){
            return top.data;
        }else{
            return -1;
        }
    }
    
    public int getMin() {
        if(top!=null){
            return top.min;
        }else{
            return -1;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */