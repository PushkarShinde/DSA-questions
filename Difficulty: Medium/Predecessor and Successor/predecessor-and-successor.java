/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    int maxPre=Integer.MIN_VALUE;
    int minSuc=Integer.MAX_VALUE;
    Node max;
    Node min;
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> res=new ArrayList<>();
        inorder(root, key);
        res.add(max);
        res.add(min);
        return res;
    }
    private void inorder(Node node, int key){
        if(node==null) return;
        inorder(node.left, key);
        if(node.data<key && node.data>maxPre){
            maxPre=node.data;
            max=node;
        }
        if(node.data>key && minSuc>node.data){
            minSuc=node.data;
            min=node;
        }
        inorder(node.right,key);
    }
}