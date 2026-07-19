/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Node{
        int level;
        TreeNode node;
        Node(int l, TreeNode n){
            level=l;
            node=n;
        }
    }
    Map<TreeNode, TreeNode> map;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map=new HashMap<>();
        dfs(root);

        List<Integer> res=new ArrayList<>();
        Set<TreeNode> vis=new HashSet<>();
        Queue<Node> q=new ArrayDeque<>();
        q.offer(new Node(0, target));
        vis.add(target);
        while(!q.isEmpty()){
            Node cur=q.poll();
            TreeNode u=cur.node;
            int lvl=cur.level;

            if(lvl==k){
                res.add(u.val);
                continue;
            }

            if(map.containsKey(u)){
                TreeNode parent=map.get(u);
                if(!vis.contains(parent)){
                    vis.add(parent);
                    q.offer(new Node(lvl+1, parent));
                }
            }

            if(u.left!=null && !vis.contains(u.left)){
                vis.add(u.left);
                q.offer(new Node(lvl+1, u.left));
            }

            if(u.right!=null && !vis.contains(u.right)){
                vis.add(u.right);
                q.offer(new Node(lvl+1, u.right));
            }
        }

        return res;
    }

    private void dfs(TreeNode root){
        if(root==null) return;
        if(root.left!=null){
            map.put(root.left, root);
            dfs(root.left);
        }
        if(root.right!=null){
            map.put(root.right, root);
            dfs(root.right);
        }
    }
}