/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
}*/
class Solution {
    public int longestConsecutive(Node root) {
        if(root==null) return -1;
        solve(root.left, root, 1);
        solve(root.right, root, 1);
        
        return maxLen<2?-1:maxLen;
    }
    private int maxLen=-1;
    private void solve(Node cur, Node parent, int len){
        if(cur==null) return;
        
        if(cur.data-parent.data!=1){
            len=1;
        }else{
            len++;
        }
        maxLen=Math.max(maxLen, len);
        solve(cur.left,cur, len);
        solve(cur.right,cur, len);
    }
}