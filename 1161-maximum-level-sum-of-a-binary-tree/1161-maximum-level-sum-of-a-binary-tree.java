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
class Node{
    TreeNode node;
    int level;
    Node(TreeNode node, int level){
        this.node=node;
        this.level=level;
    }
}
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(root,1));
        Map<Integer, Integer> map=new HashMap<>();
        while(!q.isEmpty()){
            Node cur=q.poll();
            TreeNode node=cur.node; 
            int level=cur.level;
            map.put(level,map.getOrDefault(level,0)+node.val);
            if(node.left!=null)q.offer(new Node(node.left,level+1));
            if(node.right!=null)q.offer(new Node(node.right,level+1));
        }
        int minSum=Integer.MIN_VALUE;
        int res=Integer.MAX_VALUE;
        for(int key:map.keySet()){
            if(minSum<map.get(key)){
                res=key;
                minSum=map.get(key);
            }
        }
        return res;
    }
}