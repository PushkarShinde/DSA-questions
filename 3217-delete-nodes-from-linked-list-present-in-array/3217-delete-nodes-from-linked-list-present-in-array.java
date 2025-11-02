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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set=new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        while(head!=null && set.contains(head.val)) head=head.next;
        if(head==null) return null;

        ListNode pre=head;
        ListNode cur=head.next;
        while(cur!=null){
            int x=cur.val;
            if(set.contains(x)){
                pre.next=cur.next;
                cur=cur.next;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return head;
    }
}