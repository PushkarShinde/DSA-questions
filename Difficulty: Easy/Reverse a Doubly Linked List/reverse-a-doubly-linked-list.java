/*
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        if(head==null) return null;
        DLLNode cur=head;
        DLLNode newHead=null;
        while(cur!=null){
            DLLNode temp=cur.prev;
            cur.prev=cur.next;
            cur.next=temp;
            
            newHead=cur;
            cur=cur.prev;
        }
        return newHead;
    }
}