/*
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
*/

class Solution {
    private int moves=0;
    public int distCandy(Node root) {
        solve(root);
        return moves;
    }
    private int solve(Node node){
        if(node==null) return 0;
        
        int left=solve(node.left);
        int right=solve(node.right);
        
        moves+=(Math.abs(left)+Math.abs(right));
        
        return left+right+node.data-1; 
    }
}