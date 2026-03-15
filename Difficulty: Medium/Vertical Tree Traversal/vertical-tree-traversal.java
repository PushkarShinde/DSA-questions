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

class Pair{
    Node node;
    int line;
    Pair(Node node, int line){
        this.node=node;
        this.line=line;
    }
}

class Solution {
    @SuppressWarnings("unchecked")
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Map<Integer, List<Integer>> map=new TreeMap<>();
        map.computeIfAbsent(0,k->new ArrayList<>()).add(root.data);
        
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair cur=q.poll();
            Node node=cur.node;
            int line=cur.line;
            if(node.left!=null){
                map.computeIfAbsent(line-1,k->new ArrayList<>()).add(node.left.data);
                q.offer(new Pair(node.left, line-1));
            }
            if(node.right!=null){
                map.computeIfAbsent(line+1,k->new ArrayList<>()).add(node.right.data);
                q.offer(new Pair(node.right, line+1));
            }
        }
        
        for(int key:map.keySet()){
            List<Integer> list=map.get(key);
            res.add(new ArrayList(list));
        }
        return res;
    }
}