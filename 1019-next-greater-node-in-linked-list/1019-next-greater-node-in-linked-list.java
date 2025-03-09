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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        
        // Convert LinkedList to ArrayList
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        
        int n = values.size();
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stores indices
        
        // Traverse list and use a stack to find next greater node
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && values.get(stack.peek()) < values.get(i)) {
                result[stack.pop()] = values.get(i);
            }
            stack.push(i);
        }
        
        return result;
    }
}