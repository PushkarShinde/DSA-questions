/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Pair{
    Node node;
    int line;
    Pair(int line, Node node){
        this.node=node;
        this.line=line;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Map<Integer, Integer> map=new TreeMap<>();
        map.put(0,root.data);
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(0,root));
        
        while(!q.isEmpty()){
            Pair cur=q.poll();
            int line=cur.line;
            Node node=cur.node;
            if(!map.containsKey(line)) map.put(line, node.data);
            
            if(node.left!=null){
                q.offer(new Pair(line-1, node.left));
            }
            if(node.right!=null){
                q.offer(new Pair(line+1, node.right));
            }
        }
        
        for(int key:map.keySet()){
            int val=map.get(key);
            res.add(val);
        }
        
        return res;
    }
}