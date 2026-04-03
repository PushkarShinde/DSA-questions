class Solution {
    int rootAns=0;
    int[] count;
    int n;
    List<Integer>[] adj;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n=n;
        adj=new ArrayList[n];
        count=new int[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        dfsRoot(0,-1,0);//(parent, previous, distance)

        int[] res=new int[n];
        res[0]=rootAns;

        dfs(0,-1,res);//(parent, pre,res)

        return res;
    }

    private void dfs(int parent, int pre, int[] res){
        for(int child:adj[parent]){
            if(child==pre) continue;
            res[child]=res[parent]-count[child]+(n-count[child]);
            dfs(child, parent, res);
        }
    }

    private int dfsRoot(int parent, int pre, int dist){
        int totalCount=1;
        rootAns+=dist;
        for(int child:adj[parent]){
            if(child==pre) continue;
            totalCount+=dfsRoot(child, parent, dist+1);
        }
        count[parent]=totalCount;
        return totalCount;
    }
}