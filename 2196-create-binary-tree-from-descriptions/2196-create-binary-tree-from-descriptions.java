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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> children=new HashSet<>();
        Map<Integer, TreeNode> node=new HashMap<>();

        for(int[] d:descriptions){
            int parent=d[0];
            int child=d[1];
            int isleft=d[2];

            node.putIfAbsent(parent, new TreeNode(parent));
            node.putIfAbsent(child, new TreeNode(child));

            if(isleft==1){
                node.get(parent).left=node.get(child);
            }else{
                node.get(parent).right=node.get(child);
            }
            children.add(child);
        }
        
        for(int[] d:descriptions){
            int parent=d[0];
            if(!children.contains(parent)) return node.get(parent);
        }
        return null;
    }
    private TreeNode compute(Map<Integer, List<int[]>> map, TreeNode root){
        int val=root.val;
        if(!map.containsKey(val)) return root;

        for(int[] child:map.get(val)){
            TreeNode ch=compute(map, new TreeNode(child[0]));
            if(ch!=null){
                if(child[1]==1){
                    root.left=ch;
                }else{
                    root.right=ch;
                }
            }
        }
        return root;
    }
}