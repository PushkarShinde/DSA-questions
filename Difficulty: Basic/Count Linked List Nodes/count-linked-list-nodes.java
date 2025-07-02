/*Complete the function below*/
/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        if(head==null) return 0; 
        int count=0;
        Node ptr=head;
        while(ptr!=null){
            count++;
            ptr=ptr.next;
        }
        return count;
    }
}