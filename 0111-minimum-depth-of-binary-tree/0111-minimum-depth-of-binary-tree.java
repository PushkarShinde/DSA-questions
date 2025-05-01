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
    // // RECURSIVE DFS SOLUTION 
    // public int minDepth(TreeNode root) {
    //     if(root==null) return 0;
    //     int left=minDepth(root.left);
    //     int right=minDepth(root.right);
    //     // agar donomese koi child null hai toh dusre ko consider karo
    //     if(root.left==null) return right+1;
    //     if(root.right==null) return left+1;
    //     // agar dono exist karte hai toh dono se jo chota ho usko count karo
    //     return Math.min(left, right)+1;
    // }
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root); 
        int depth=1;
        while(!queue.isEmpty()){
            int s=queue.size();
            for(int i=0;i<s;i++){
                TreeNode node=queue.poll();
                // check karo ki leaf hai kya, hoga toh abhitak ka depth return kardo, kaam ho gaya
                if(node.left==null && node.right==null) return depth; 
                // agar leaf nahi hoga toh aur depth me jao
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}

/**✅ Why BFS is more efficient for minDepth?
BFS traverses level by level, and the moment it finds the first leaf node, it returns the current depth. This avoids unnecessary traversal of deeper nodes, especially useful in unbalanced trees. */