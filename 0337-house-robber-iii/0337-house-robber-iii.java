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
    public int rob(TreeNode root) {
        int[] res=solve(root);
        return Math.max(res[0], res[1]);
    }

    private int[] solve(TreeNode root){
        if(root==null) return new int[]{0,0};

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        int[] current = new int[2];

        current[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        current[1] = root.val + left[0] + right[0];
        return current;       
    }
}