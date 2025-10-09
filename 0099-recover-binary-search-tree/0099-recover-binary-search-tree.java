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
    TreeNode one=null;
    TreeNode two=null;
    TreeNode pre=new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=one.val;
        one.val=two.val;
        two.val=temp;
    }
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(root.val<pre.val){
            if(one==null) one=pre;
            two=root;
        }
        pre=root;
        inorder(root.right);
    }
}