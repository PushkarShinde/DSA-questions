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
        ListNode cur=head;
        ListNode pre=cur;
        while(cur!=null){
            int x=cur.val;
            if(set.contains(x)){
                if(cur==head){
                    ListNode temp=head;
                    head=head.next;
                    temp.next=null;
                    cur=head;
                    pre=cur;
                }else{
                    cur=cur.next;
                    pre.next=cur;
                }
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return head;
    }
}