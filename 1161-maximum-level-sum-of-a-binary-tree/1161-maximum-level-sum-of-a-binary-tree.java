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
// class Node{
//     TreeNode node;
//     int level;
//     Node(TreeNode node, int level){
//         this.node=node;
//         this.level=level;
//     }
// }
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        // Map<Integer, Integer> map=new HashMap<>();
        int level=1;
        int res=1;
        int maxSum=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size=q.size();
            int sum=0;
            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                sum+=cur.val;
                if(cur.left!=null)q.offer(cur.left);
                if(cur.right!=null)q.offer(cur.right);
            }
            if(maxSum<sum){
                res=level;
                maxSum=sum;
            }
            level++;
        }
        return res;
    }
}