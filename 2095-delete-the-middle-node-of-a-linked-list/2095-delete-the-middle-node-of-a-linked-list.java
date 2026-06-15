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
    public ListNode deleteMiddle(ListNode head) {
        int n=0;
        ListNode temp=head;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        if(n==1) return null;

        int mid=n/2;

        ListNode cur=new ListNode(head.val);
        ListNode res=cur;
        temp=head;
        int m=0;
        while(m<n && temp!=null){
            if(m==mid || m==0){
                temp=temp.next;
                m++;
                continue;
            }
            ListNode next=new ListNode(temp.val);
            cur.next=next;
            cur=next;

            temp=temp.next;
            m++;
        }
        return res;
    }
}