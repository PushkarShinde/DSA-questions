/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // private ListNode mergeTwoList(ListNode l1, ListNode l2){

    //     return l1;
    // }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node: lists){
            if(node!=null) pq.offer(node);
        }
        
        ListNode head=new ListNode(0);
        ListNode curr=head;
        while(!pq.isEmpty()){
            ListNode smallest=pq.poll();
            curr.next=smallest;
            curr=curr.next;

            if(smallest.next!=null){
                pq.offer(smallest.next);
            }
        }
        return head.next;//0 ke baad ke nodes chahiye isiliye
    }
}