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

class Solution{
    int count;
    Map<Integer, Integer> map;
    public int countAllPaths(Node root, int k){
        map=new HashMap<>();
        map.put(0,1);
        count=0;
        // dfs(root, k, root.data);
        traverse(root, k);
        return count;
    }
    
    private void traverse(Node node, int k){
        if(node==null) return;
        dfs(node, k);
        traverse(node.left, k);
        traverse(node.right, k);
    }
    
    private void dfs(Node node, int k){
        if(node==null) return;
        if(k==node.data){
            count++;
        }
        dfs(node.left, k-node.data);
        dfs(node.right, k-node.data);
    }
    
    // private void dfs(Node node, int k, int sum){
    //     if(node==null) return;
    //     sum+=node.data;
    //     if(map.containsKey(sum-k)){
    //         count+=map.get(sum-k);
    //     }
        
    //     map.put(sum, map.getOrDefault(sum, 0)+1);
        
    //     dfs(node.left, k, sum);
    //     dfs(node.right, k, sum);
        
    //     map.put(sum, map.getOrDefault(sum, 0)-1);
    //     if(map.get(sum)==0) map.remove(sum);
    // }
}