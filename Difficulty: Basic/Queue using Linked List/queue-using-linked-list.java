/*The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
	QueueNode(int a)
	{
	    data = a;
	    next = null;
	}
}*/

class MyQueue{
    QueueNode front=null, rear=null;
    
    //Function to push an element into the queue.
	void push(int a){
        QueueNode newNode=new QueueNode(a);
        if(rear==null){
            rear=newNode;
            front=rear;
        }else{
            rear.next=newNode;
            rear=rear.next;
        }
	}
	
    //Function to pop front element from the queue.
	int pop(){
	    if(front==null) return -1;
        int res=front.data;
        front=front.next;
        if(front==null) rear=null;
        return res;
	}
}




