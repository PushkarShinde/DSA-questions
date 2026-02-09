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
    List<Integer> num;
    public TreeNode balanceBST(TreeNode root) {
        num=new ArrayList<>();
        inorder(root);
        int l=0, r=num.size()-1;
        return balance(l, r);
    }
    private void inorder(TreeNode root){
        if(root.left!=null) inorder(root.left);
        num.add(root.val);
        if(root.right!=null) inorder(root.right);
    }
    private TreeNode balance(int l, int r){
        if(l>r) return null;
        int mid=(l+r)/2;
        TreeNode root=new TreeNode(num.get(mid));
        root.left=balance(l, mid-1);
        root.right=balance(mid+1, r);
        return root;
    }
}