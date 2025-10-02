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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> nodes=new LinkedList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()){
            int n=nodes.size();
            for(int i=0;i<n;i++){
                TreeNode node=nodes.poll();
                if(i==n-1) res.add(node.val);
                if(node.left!=null)nodes.offer(node.left);
                if(node.right!=null)nodes.offer(node.right);
            }
        }
        return res;
    } 
}