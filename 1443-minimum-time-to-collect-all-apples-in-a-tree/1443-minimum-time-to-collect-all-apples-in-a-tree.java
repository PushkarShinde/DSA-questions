class Solution {
    List<Integer>[] adj;
    List<Boolean> hasApple;
    int n;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        adj=new ArrayList[n];
        this.hasApple=hasApple;
        this.n=n;
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj[u].add(v);
            adj[v].add(u);
        }

        return dfs(0, -1);
    }

    private int dfs(int node, int parent){
        int total=0;

        for(int v:adj[node]){
            if(v==parent) continue;

            int score=dfs(v,node);
            if(score>0 || hasApple.get(v)){
                total+=score+2;
            }
        }

        return total;
    }
}