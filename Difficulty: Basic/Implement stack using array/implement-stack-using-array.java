class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        if(top<999)
        arr[++top]=x;
    }

    public int pop() {
        int topVal=-1;
        if(top>=0) {
            topVal=arr[top--];
        }
        return topVal;
    }
}