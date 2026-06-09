/* Structure of linked list node
class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    Node compute(Node head) {
        return solve(head,0);
    }
    private Node solve(Node head, int high){
        int val=head.data;
        if(head.next==null) return new Node(val);
        
        Node root=solve(head.next, high);
        if(root.data<=val){
            Node newRoot=new Node(val);
            newRoot.next=root;
            return newRoot;
        }
        return root;
    }
}