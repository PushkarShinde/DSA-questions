class Solution {
    List<Integer>[] adj;
    List<Integer>[] radj;
    @SuppressWarnings("unchecked")
    public int findMotherVertex(int V, int[][] edges) {
        adj=new ArrayList[V];
        radj=new ArrayList[V];
        
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
            radj[i]=new ArrayList<>();
        }
        for(int[] e: edges){
            int u=e[0];
            int v=e[1];
            adj[u].add(v);
            radj[v].add(u);
        }
        
        // Step 1: DFS on original graph, collect finish order
        boolean[] vis=new boolean[V];
        List<Integer> finishOrder=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(!vis[i]) dfsFinish(i, vis, finishOrder);
        }
        
        int candidate=finishOrder.get(finishOrder.size()-1);
        
        // Step 2: Verify candidate can reach all V vertices
        Arrays.fill(vis,false);
        int reachable=dfsCount(candidate, vis);
        if(reachable<V) return -1;
        
        // Step 3: Find all vertices in candidate's SCC via reverse graph
        // (all vertices that can reach candidate = same SCC)
        Arrays.fill(vis, false);
        int minVal=candidate;
        Deque<Integer> stack=new ArrayDeque<>();
        stack.push(candidate);
        vis[candidate]=true;
        
        while(!stack.isEmpty()){
            int u=stack.pop();
            minVal=Math.min(minVal, u);
            for(int v: radj[u]){
                if(!vis[v]){
                    stack.push(v);
                    vis[v]=true;
                }
            }
        }
        return minVal;
    }
    
    // Iterative DFS — records finish order (post-order)
    private int dfsFinish(int u, boolean[] vis, List<Integer> order){
        vis[u]=true;
        int res=1;
        for(int v:adj[u]){
            if(!vis[v]){
                res+=dfsFinish(v, vis, order);
            }
        }
        order.add(u);
        return res;
    }
    
    private int dfsCount(int u, boolean[] vis){
        int res=1;
        vis[u]=true;
        for(int v:adj[u]){
            if(!vis[v]){
                res+=dfsCount(v, vis);
            }
        }
        return res;
    }
}