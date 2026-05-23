/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
class Solution {
    public void toSumTree(Node root) {
        solve(root);
        
    }
    private int solve(Node root){
        if(root==null) return 0;
        int val=root.data;
        if(root.left==null && root.right==null){
            root.data=0;
            return val;
        }
        int sum=solve(root.left)+solve(root.right);
        root.data=sum;
        return val+sum;
    }
}