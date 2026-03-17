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
    private int res;
    public int amountOfTime(TreeNode root, int start) {
        res=0;
        dfs(root, start);
        return res;
    }
    private int dfs(TreeNode node, int start){
        if(node==null) return 0;
        int left=dfs(node.left, start);
        int right=dfs(node.right, start);
        if(node.val==start){
            res=Math.max(left,right); 
            return -1;
        }
        if(right<0){
            res=Math.max(res, left+Math.abs(right));
            return right-1;
        }
        if(left<0){
            res=Math.max(res, Math.abs(left)+right);
            return left-1;
        }
        return Math.max(left, right)+1;
    }
}