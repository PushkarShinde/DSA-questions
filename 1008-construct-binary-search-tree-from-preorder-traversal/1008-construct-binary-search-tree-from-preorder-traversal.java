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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            TreeNode cur=root;
            while(true){
                if(preorder[i]>cur.val){
                    if(cur.right==null){
                        cur.right=new TreeNode(preorder[i]);
                        break;
                    }
                    cur=cur.right;
                }else if(preorder[i]<cur.val){
                    if(cur.left==null){
                        cur.left=new TreeNode(preorder[i]);
                        break;
                    }
                    cur=cur.left;
                }
            }
        }
        return root;
    }
}