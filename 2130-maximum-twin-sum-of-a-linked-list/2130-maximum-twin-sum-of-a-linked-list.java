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
    public int pairSum(ListNode head) {
        List<Integer> res=new ArrayList<>();
        ListNode node=head;
        while(node!=null){
            res.add(node.val);
            node=node.next;
        }

        int n=res.size();
        int max=0;
        for(int i=0;i<n/2;i++){
            max=Math.max(max, res.get(i)+res.get(n-i-1));
        }
        return max;
    }
}