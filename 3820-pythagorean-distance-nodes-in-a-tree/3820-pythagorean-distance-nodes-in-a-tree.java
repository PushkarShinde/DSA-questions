class Solution {
    Map<Integer, List<Integer>> adj;
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        adj=new HashMap<>();
        for(int[] i:edges){
            int u=i[0], v=i[1];
            adj.computeIfAbsent(u, k-> new ArrayList<>()).add(v); 
            adj.computeIfAbsent(v, k-> new ArrayList<>()).add(u); 
        }
        int[] dx=bfs(x,n);
        int[] dy=bfs(y,n);
        int[] dz=bfs(z,n);
        int res=0;
        for(int i=0;i<n;i++){
            if(dx[i]==Integer.MAX_VALUE ||
            dy[i]==Integer.MAX_VALUE ||
            dz[i]==Integer.MAX_VALUE) continue;
            int[] d={dx[i],dy[i],dz[i]};
            Arrays.sort(d);
            if((d[0]*d[0]+d[1]*d[1])==d[2]*d[2]) res++;
        }
        return res;
    }
    private int[] bfs(int src,int dest){
        Queue<Integer> q=new LinkedList<>();
        q.offer(src);
        int[] dist=new int[dest+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v:adj.getOrDefault(u, List.of())){
                if(dist[v]==Integer.MAX_VALUE){
                    dist[v]=dist[u]+1;
                    q.offer(v);
                }
            }
        }
        return dist;
    }
}