class Solution {
    private int mod=(int)1e9+7;
    public int assignEdgeWeights(int[][] edges) {
        int n=edges.length+1;
        
        List<Integer>[] adj=new ArrayList[n+1];
        for(int i=0;i<=n;i++) adj[i]=new ArrayList<>();
        for(int i=1;i<n;i++){
            int x=edges[i-1][0];
            int y=edges[i-1][1];
            adj[x].add(y);
            adj[y].add(x);
        }

        boolean[] vis=new boolean[n+1];
        vis[1]=true;
        Queue<Integer> q= new LinkedList<>();
        q.offer(1);

        int depth=-1;
        while(!q.isEmpty()){
            int size=q.size();
            depth++;
            while(size-->0){
                int cur=q.poll();
                for(int v:adj[cur]){
                    if(!vis[v]) {
                        q.offer(v);
                        vis[v]=true;
                    }
                }
            }
        }

        return power(2,depth-1);
    }

    private int power(int a, int b){
        long res=1;
        long base=a;

        while(b>0){
            if((b&1)==1) res=(res*base)%mod;
            base=(base*base)%mod;
            b/=2;
        }
        return (int)res;
    }
}