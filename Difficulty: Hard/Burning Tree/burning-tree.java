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
    public int minTime(Node root, int target){
        Map<Integer, List<Integer>> adj=new HashMap<>();
        generateGraph(adj, null, root);
        
        int time=0;
        Set<Integer> vis=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        q.offer(target);
        vis.add(target);
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int cur=q.poll();
                for(int val: adj.getOrDefault(cur, new ArrayList<>())){
                    if(!vis.contains(val)){
                        q.offer(val);
                        vis.add(val);
                    }
                }
            }
            time++;
        }
        return time-1;
    }
    
    private void generateGraph(Map<Integer, List<Integer>> adj, Node parent, Node cur){
        if(cur==null) return;
        if(parent!=null){
            adj.computeIfAbsent(cur.data, k-> new ArrayList<>()).add(parent.data);
            adj.computeIfAbsent(parent.data, k-> new ArrayList<>()).add(cur.data);
        }

        generateGraph(adj, cur, cur.left);
        generateGraph(adj, cur, cur.right);
    }
}