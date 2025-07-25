class MyQueue {

    int front, rear;
    int arr[] = new int[100005];

    MyQueue() {
        front = 0;
        rear = 0;
    }

    // Function to push an element x in a queue.
    void push(int x) {
        arr[rear]=x;
        rear++;
    }

    // Function to pop an element from queue and return that element.
    int pop() {
        if(front<rear){
            return arr[front++];
        }else{
            return -1;
        }
    }
}