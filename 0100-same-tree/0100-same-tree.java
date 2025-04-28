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
    // private void inorder(TreeNode root, List<Integer> list){
    //     if(root!=null){
    //         inorder(root.left,list);
    //         list.add(root.val);
    //         inorder(root.right,list);
    //     }
    // }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // List<Integer> plist=new ArrayList<>();
        // List<Integer> qlist=new ArrayList<>();
        // inorder(p, plist);
        // inorder(q, qlist);
        // if(plist.size()==qlist.size()){
        //     return plist.equals(qlist);
        // }
        // return false;

        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right); // wow
    }
}

/**
Understand the problem clearly:
    Is it just value comparison?
    Or also structure comparison?
    If structure matters (like trees), always think recursion or DFS.
    Avoid converting complex structures (trees) into arrays/lists unnecessarily. 
*/