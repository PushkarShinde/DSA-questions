/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return 1+solve(root.right, root.val)+solve(root.left, root.val);
    }

    private int solve(TreeNode root, int pre){
        if(root==null) return 0;

        int res=0;
        if(root.val>=pre) res++;

        return res+solve(root.right, Math.max(pre, root.val))+solve(root.left, Math.max(pre, root.val));
    }
}