// User function Template for Java

/* Node of a linked list
  class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/
class Solution {
    static boolean searchKey(int n, Node head, int key) {
        if(head==null) return false; 
        Node ptr=head;
        while(ptr!=null){
            if(ptr.data==key) return true;
            ptr=ptr.next;
        }
        return false;
    }
}