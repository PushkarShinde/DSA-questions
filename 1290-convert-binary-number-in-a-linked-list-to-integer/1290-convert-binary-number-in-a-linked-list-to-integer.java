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
    public int getDecimalValue(ListNode head) {
        int dig=0;
        while(head!=null){
            dig=dig<<1 | head.val;// Shift left and add current bit
            head=head.next;
        }

        return dig;
    }
}