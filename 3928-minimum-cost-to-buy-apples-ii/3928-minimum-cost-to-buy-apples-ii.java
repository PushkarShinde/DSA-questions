class Solution {
    public int[] minCost(int n, int[] prices, int[][] roads) {
        //ans[i] = min(prices[j] + empty_dist[i][j] + loaded_dist[j][i])
        List<long[]>[] empty=new ArrayList[n];
        List<long[]>[] loaded=new ArrayList[n];
        for(int i=0;i<n;i++){
            empty[i]=new ArrayList<>();
            loaded[i]=new ArrayList<>();
        }
        for(int[] road: roads){
            int u=road[0];
            int v=road[1];
            long cost=road[2];
            long tax=road[3];
            empty[u].add(new long[]{v,cost});
            empty[v].add(new long[]{u,cost});
            loaded[v].add(new long[]{u,cost*tax});
            loaded[u].add(new long[]{v,cost*tax});
        }

        long[][] emp=new long[n][n];
        long[][] load=new long[n][n];
        for(int i=0;i<n;i++){
            emp[i]=dijkstra(i,n,empty);
            load[i]=dijkstra(i,n,loaded);
        }

        int[] res=new int[n];
        for(int i=0;i<n;i++){
            long minCost=prices[i];
            for(int j=0;j<n;j++){
                if (emp[i][j]!=Long.MAX_VALUE && load[j][i]!=Long.MAX_VALUE){
                    long totalCost = (long) prices[j] + emp[i][j] + load[j][i];
                    minCost=Math.min(minCost, totalCost);
                }
            }
            res[i]=(int)minCost;
        }
        return res;
    }

    private long[] dijkstra(int src, int n, List<long[]>[] graph){
        long[] dist=new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src]=0;

        PriorityQueue<long[]> pq=new PriorityQueue<>(Comparator.comparingLong(x->x[0]));
        pq.offer(new long[]{0,src});

        while(!pq.isEmpty()){
            long[] cur=pq.poll();
            long d=cur[0];
            int u=(int)cur[1];
            if(dist[u]<d) continue;

            for(long[] child: graph[u]){
                int v=(int)child[0];
                long cost=child[1];
                if(dist[u]+cost<dist[v]){
                    dist[v]=dist[u]+cost;
                    pq.offer(new long[]{dist[v],v});
                }
            }
        }
        return dist;
    }
}