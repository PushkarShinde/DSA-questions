/*

Definition for doubly Link List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        int ind=1;
        if(head==null) return null;
        if(x==1){
            if(head.next!=null){
                head.next.prev=null;
                return head.next;
            }else{
                return null;
            }
        }
        Node ptr=head;
        while(ptr!=null && ind<x-1){
            ptr=ptr.next;
            ind++;
        }
        if (ptr == null || ptr.next == null) {
            return head; // Position out of bounds, nothing to delete
        }
        Node temp=ptr.next;
        ptr.next=temp.next;
        if(temp.next!=null){
            temp.next.prev=ptr;
        }
        return head;
    }
}