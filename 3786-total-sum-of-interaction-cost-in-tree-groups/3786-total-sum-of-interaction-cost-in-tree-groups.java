class Solution {
    long res=0;
    public long interactionCosts(int n, int[][] edges, int[] group){
        List<Integer>[] adj = new ArrayList[n];
        for (int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for (int[] e:edges){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        for(int i=1;i<21;i++){
            int total=0;
            for(int x:group){
                if(x==i) total++;
            }
            if(total<2) continue;
            dfs(0,-1, i,adj, group, total);
        }
        return res;
    }
    private int dfs(int u, int parent, int g, List<Integer>[] adj, 
                    int[] group, int total){
        int count=(group[u]==g)?1:0;
        for(int v:adj[u]){
            if(v==parent) continue;
            int sub=dfs(v,u,g,adj,group,total);
            res+=(long)sub*(total-sub);
            count+=sub;
        }
        return count;
    }
}