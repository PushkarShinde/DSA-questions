class MyStack {
    Queue<Integer> queMain;
    Queue<Integer> queHelp;
    public MyStack() {
        queMain=new LinkedList<>();
        queHelp=new LinkedList<>();
    }
    /**
    push(x)->
        Enqueue x into qHelp.
        Move all items from qMain into qHelp (preserves order, makes x the new front).
        Swap the two references (qMain ←→ qHelp).
        After the swap, the newest element is at the front of qMain, so pop and top are O(1).
     */
    public void push(int x) {
        queHelp.offer(x);
        while(!queMain.isEmpty()){
            queHelp.offer(queMain.poll());
        }
        Queue<Integer> queTemp=queHelp;
        queHelp=queMain;
        queMain=queTemp;
    }
    
    public int pop(){
        if(queMain.isEmpty()){
            return -1;
        }
        return queMain.poll();
    }
    
    public int top(){
        if(queMain.isEmpty()){
            return -1;
        }
        return queMain.peek();
    }
    
    public boolean empty() {
        return queMain.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */