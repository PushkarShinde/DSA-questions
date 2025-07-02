/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/

class Solution {
    // Function to insert a new node at given position in doubly linked list.
    Node addNode(Node head, int p, int x) {
        Node newNode=new Node(x);
        if(head==null) return newNode;
        Node ptr=head;
        int ind=0;
        while(ind<p && ptr.next!=null){
            ptr=ptr.next;
            ind++;
        }
        Node temp=ptr.next;
        ptr.next=newNode;
        newNode.prev=ptr;
        newNode.next=temp;
        if(temp!=null){
            temp.prev=newNode;
        }
        return head;
    }
}