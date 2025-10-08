/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode pp=root;
        while(pp!=null){
            if(p.val<pp.val && q.val<pp.val){
                pp=pp.left;
            }else if(p.val>pp.val && q.val>pp.val){
                pp=pp.right;
            }else{
                return pp;
            }
        }
        return null;
    }
}