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
    int level;
    TreeNode node;
    Node(int l, TreeNode n){
        this.level=l;
        this.node=n;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, TreeNode> map=new TreeMap<>();
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;

        Queue<Node> q=new ArrayDeque<>();
        q.offer(new Node(0,root));
        while(!q.isEmpty()){
            Node cur=q.poll();
            TreeNode parent=cur.node;
            int level=cur.level;

            map.put(level, parent);

            if(parent.left!=null){
                q.offer(new Node(level+1, parent.left));
            }
            if(parent.right!=null){
                q.offer(new Node(level+1, parent.right));
            }
        }

        for(int key: map.keySet()){
            TreeNode node=map.get(key);
            res.add(node.val);
        }

        return res;
    }
}