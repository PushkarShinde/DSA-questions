class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        if(n==1) return 0;
        if(edges.length==0) return -1;

        List<int[]>[] adj=new ArrayList[n+1];
        for(int i=0;i<=n;i++) adj[i]=new ArrayList<>();
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            adj[u].add(new int[]{v,w});
        }

        int[][] dist=new int[n][k+1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][1]=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->x[1]-y[1]);//[v,w,conseq]
        pq.offer(new int[]{0,0,1});
        
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int u=cur[0];
            int w=cur[1];
            int c=cur[2];

            if(dist[u][c]<w) continue;

            char pre=labels.charAt(u);
            for(int[] child:adj[u]){
                int v=child[0];
                int d=child[1];

                char now=labels.charAt(v);
                int newC = (pre == now) ? c + 1 : 1;
                if(newC>k) continue;

                if(w+d<dist[v][newC]){
                    dist[v][newC]=w+d;
                    pq.offer(new int[]{v,dist[v][newC], newC});
                }
            }
        }

        int res=Integer.MAX_VALUE;
        for(int d:dist[n-1]){
            res=Math.min(res, d);
        }

        return (res!=Integer.MAX_VALUE)?res:-1;
    }
}