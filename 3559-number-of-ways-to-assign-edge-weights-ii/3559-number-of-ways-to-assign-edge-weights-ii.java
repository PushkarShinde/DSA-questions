class Solution {
    private List<Integer>[] adj;
    private long mod=(long)1e9+7;
    private int log=17;
    private int n;
    private int[] depth;
    private int[][] up;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        n=edges.length+1;
        adj=new ArrayList[n+1];
        for(int i=0; i<=n; i++) adj[i]=new ArrayList<>();
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        up=new int[n+1][log];
        depth=new int[n+1];
        boolean[] vis=new boolean[n+1];

        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        vis[1]=true;
        depth[1]=0;
        up[1][0]=1;

        while(!q.isEmpty()){
            int cur=q.poll();
            for(int v:adj[cur]){
                if(vis[v]) continue;

                vis[v]=true;
                q.offer(v);
                depth[v]=depth[cur]+1;
                up[v][0]=cur;
            }
        }

        for(int j=1;j<log;j++){//O(n logn)
            for(int i=1;i<=n;i++){
                up[i][j]=up[up[i][j-1]][j-1];
            }
        }

        long[] pow=new long[n+1];
        pow[0]=1;
        for(int i=1;i<=n;i++){
            pow[i]=(2L*pow[i-1])%mod;
        }

        int m=queries.length;
        int[] res=new int[m];
        for(int i=0;i<m;i++){
            int[] qu=queries[i];
            int u=qu[0], v=qu[1];
            int lca=lca(u,v);
            int d=depth[u]+depth[v]-2*depth[lca];

            if(d==0){
                res[i]=0;
            }else{
                res[i]=(int)pow[d-1];
            }
        }

        return res;
    }

    private int lca(int a, int b){
        if(depth[a]<depth[b]) {
            int temp=a;
            a=b;
            b=temp;
        }

        int dif=depth[a]-depth[b];
        for(int j=0;j<log;j++){ // O(log n)
            if(((dif>>j)&1)==1){
                a=up[a][j];
            }
        }

        if(a==b) return a;

        //lift both until they meet
        for(int j=log-1;j>=0;j--){ // O(log n)
            if(up[a][j]!=up[b][j]){
                a=up[a][j];
                b=up[b][j];
            }
        }

        return up[a][0];
    }

    // private int query(int a, int b){
    //     if(a==b) return 0;
    //     Queue<Integer> q=new LinkedList<>();
    //     q.offer(a);
    //     boolean[] vis=new boolean[n+1];
    //     vis[a]=true;
    //     int d=0;
    //     while(!q.isEmpty()){
    //         int size=q.size();

    //         while(size-->0){
    //             int cur=q.poll();
    //             if(cur==b) return d;

    //             for(int v:adj[cur]){
    //                 if(vis[v]) continue;
    //                 q.offer(v);
    //                 vis[v]=true;
    //             }
    //         }
    //         d++;
    //     }

    //     return d;
    // }

    // private int power(int a, int b){
    //     long base=a;
    //     long res=1L;
    //     while(b>0){
    //         if((b&1)==1) res=(res*base)%mod;
    //         base=(base*base)%mod;
    //         b>>=1;
    //     }
    //     return (int)res;
    // }
}