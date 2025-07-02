/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node insertAtEnd(Node head, int x) {
        Node newNode=new Node(x);
        if(head==null) return newNode; 
        Node ptr=head;
        while(ptr.next!=null){
            ptr=ptr.next;
        }
        ptr.next=newNode;
        return head;
    }
}