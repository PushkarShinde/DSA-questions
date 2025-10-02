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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes=new ArrayList<>();
        dfs(nodes, 0,0,root);
        Collections.sort(nodes, (a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0]; //col
            else if(a[1]!=b[1]) return a[1]-b[1]; //row
            else return a[2]-b[2]; //val
        });
        List<List<Integer>> res=new ArrayList<>();
        int preCol=Integer.MIN_VALUE;
        List<Integer> col=new ArrayList<>();
        for(int[] node: nodes){
            int c=node[0], r=node[1], val=node[2];
            if(preCol!=c){
                if(!col.isEmpty()) res.add(col);
                col=new ArrayList<>();
                preCol=c;
            }
            col.add(val);
        }

        res.add(col);
        return res;
    }
    private void dfs(List<int[]>nodes,int r, int c, TreeNode root){
        if(root==null) return;
        nodes.add(new int[]{c,r,root.val});
        dfs(nodes, r+1, c-1,root.left);
        dfs(nodes,r+1,c+1, root.right);
    }
}