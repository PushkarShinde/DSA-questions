/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    Map<Integer, Integer> map;
    public ArrayList<Integer> verticalSum(Node root) {
        map=new TreeMap<>();
        solve(root,0);
        ArrayList<Integer> res=new  ArrayList<>();
        for(int val:map.values()){
            res.add(val);
        }
        return res;
    }
    
    private void solve(Node root, int key){
        if(root==null) return;
        map.merge(key, root.data, Integer::sum);
        solve(root.left, key-1);
        solve(root.right, key+1);
    }
}