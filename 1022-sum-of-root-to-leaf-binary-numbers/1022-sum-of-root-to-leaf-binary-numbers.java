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
    public int sumRootToLeaf(TreeNode root) {
        if(root==null) return root.val;
        res=0;
        StringBuilder str=new StringBuilder();
        // str.append(root.val);
        solve(root,str);
        return res;
    }
    private void solve(TreeNode root,StringBuilder num){
        num.append(root.val);
        if(root.left==null && root.right==null) {
            res+=Integer.parseInt(num.toString(),2);
            num.deleteCharAt(num.length()-1);
            return;
        }
        if(root.left!=null) solve(root.left, num);
        if(root.right!=null) solve(root.right, num);
        num.deleteCharAt(num.length()-1);
    }
}