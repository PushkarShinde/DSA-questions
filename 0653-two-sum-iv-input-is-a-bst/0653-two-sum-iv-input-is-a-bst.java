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
    Set<Integer> set=new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root,set);
        for(int i:set){
            if((k-i)!=i && set.contains(k-i)) return true;
        }
        return false;
    }
    private void inorder(TreeNode root, Set<Integer> set){
        if(root==null) return;
        inorder(root.left,set);
        set.add(root.val);
        inorder(root.right,set);
    }
}