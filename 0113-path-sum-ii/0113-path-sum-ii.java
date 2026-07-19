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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        solve(root, targetSum, res, new ArrayList<>());
        return res;
    }

    private void solve(TreeNode root, int k, List<List<Integer>> res, List<Integer> list){
        if(root==null) return;

        int val=root.val;
        list.add(val);

        if(root.left==null && root.right==null){
            if(k==val){
                res.add(new ArrayList<>(list));
            }
        }else{
            solve(root.right, k-val, res, list);
            solve(root.left, k-val, res, list);
        }
        
        list.remove(list.size()-1);
    }
}