class Solution {
    private List<Integer>[] adj;
    @SuppressWarnings("unchecked")
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        adj=new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj[u].add(v);
        }
        Stack<Integer> stack=new Stack<>();
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,stack, vis);
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
    //DFS
    private void dfs(int u, Stack<Integer> stack, boolean[] vis){
        // if(vis[u]) return;
        vis[u]=true;
        for(int v: adj[u]){
            if(!vis[v]){
                dfs(v,stack, vis);
            }
        }
        stack.push(u);
    }
}