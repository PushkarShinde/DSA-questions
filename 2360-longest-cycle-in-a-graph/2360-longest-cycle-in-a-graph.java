class Solution {
    List<Integer>[] adj;
    int n;
    int maxCycle=-1;
    boolean[] vis;
    boolean[] inStack;
    int[] depth;

    public int longestCycle(int[] edges) {
        this.n=edges.length;
        adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            int v=edges[i];
            if(v!=-1) adj[i].add(v);
        }

        vis=new boolean[n];
        inStack=new boolean[n];
        depth=new int[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,0);
            }
        }

        return maxCycle;
    }

    private void dfs(int node, int d){
        vis[node]=true;
        inStack[node]=true;
        depth[node]=d;

        for(int v:adj[node]){
            if(!vis[v]){
                dfs(v,d+1);
            }else if(inStack[v]){
                maxCycle=Math.max(maxCycle, d-depth[v]+1);
            }
        }
        inStack[node]=false;
    }
}