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
    private int moves;
    public int distributeCoins(TreeNode root) {
        moves=0;
        solve(root);
        return moves;
    }
    private int solve(TreeNode node){
        if(node==null) return 0;

        int left=solve(node.left);
        int right=solve(node.right);

        moves+=Math.abs(left)+Math.abs(right);
        return left+right+node.val-1;
    }
}