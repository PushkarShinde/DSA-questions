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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        int rev=0;
        while(!qu.isEmpty()){
            int n=qu.size();
            int[] list=new int[n];
            for(int i=0;i<n;i++){
                TreeNode temp=qu.poll();
                list[i]=temp.val;
                if(temp.left!=null) qu.add(temp.left); 
                if(temp.right!=null) qu.add(temp.right); 
            }
            if(rev%2!=0) reverse(list);
            List<Integer> li=new ArrayList<>();
            for(int i=0;i<n;i++){
                li.add(list[i]);
            }
            res.add(li);
            rev++;
        }
        return res;
    }
    private int[] reverse(int[] list){
        int n=list.length;
        for(int i=0;i<n/2;i++){
            int temp=list[i];
            list[i]=list[n-1-i];
            list[n-1-i]=temp;
        }
        return list;
    }
}