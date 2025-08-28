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
    private int maxDm=0;
    private int diameter(TreeNode root){
        if(root==null) return 0;
        int left=diameter(root.left);
        int right=diameter(root.right);
        // int diam=left+right;
        maxDm=Math.max(left+right, maxDm);
        return Math.max(left,right)+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        diameter(root);
        return maxDm;
    }
}