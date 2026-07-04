class Solution {
    public int minScore(int n, int[][] roads) {
        if(n==1) return 0;
        
        List<int[]>[] adj=new ArrayList[n+1];
        for(int i=0;i<=n;i++) adj[i]=new ArrayList<>();
        for(int[] r:roads){
            int u=r[0];
            int v=r[1];
            int d=r[2];
            adj[u].add(new int[]{v,d});
            adj[v].add(new int[]{u,d});
        }

        int[] dist=new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->x[1]-y[1]);
        pq.offer(new int[]{1,Integer.MAX_VALUE});

        int res=Integer.MAX_VALUE;

        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int u=cur[0];
            int d=cur[1];

            if(u==n){
                res=Math.min(res, d);
            }

            if(dist[u]<d) continue;

            for(int[] next: adj[u]){
                int v=next[0];
                int vd=next[1];

                int nd=Math.min(vd,d);
                if(nd<dist[v]){
                    dist[v]=nd;
                    pq.offer(new int[]{v,nd});
                }
            }
        }

        return res;
    }
}