class Solution {
    private int maxCycle=-1;
    private int[] depth;
    private boolean[] inStack;
    private boolean[] vis;
    private List<Integer>[] adj;
    
    @SuppressWarnings("unchecked")
    public int longestCycle(int V, int[][] edges) {
        adj=new ArrayList[V];
        for(int i=0;i<V;i++) adj[i]=new ArrayList<>();
        
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adj[u].add(v);
        }
        
        vis=new boolean[V];
        depth=new int[V];
        inStack=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,0);
            }
        }
        return maxCycle;
    }
    
    private void dfs(int node, int len){
        inStack[node]=true;
        vis[node]=true;
        depth[node]=len;
        
        for(int v:adj[node]){
            if(!vis[v]){
                dfs(v, len+1);
            }else if(inStack[v]){//cycle found
                maxCycle=Math.max(maxCycle, len-depth[v]+1);
            }
        }
        inStack[node]=false;
    }
}