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
    private long maxProd=0;
    private int mod=(int)1e9+7;
    public int maxProduct(TreeNode root) {
        long totalSum=dfs(root);
        check(root, totalSum);
        return (int)(maxProd%mod);
    }
    private long dfs(TreeNode root){
        long sum=root.val;
        if(root.left!=null)sum+=dfs(root.left);
        if(root.right!=null)sum+=dfs(root.right);
        return sum;
    }
    private long check(TreeNode root, long total){
        if(root==null) return 0;
        long left=check(root.left,total);
        long right=check(root.right,total);
        long sum=left+right+root.val;
        if(root.left!=null)maxProd=Math.max(maxProd,left*(total-left));
        if(root.right!=null)maxProd=Math.max(maxProd,right*(total-right));
        return sum;
    }
}