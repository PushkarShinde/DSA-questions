class Solution {
    class Pair{
        int x;
        long distance;
        Pair(int x, long distance){
            this.x=x;
            this.distance=distance;
        }
    }
    final int mod=(int)1e9+7; 
    public int countPaths(int n, int[][] roads) {
        int edges=roads.length;
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads) {
            int u =road[0];
            int v =road[1];
            int time =road[2];
            adj.get(u).add(new Pair(v,time));
            adj.get(v).add(new Pair(u,time));
        }
        long[] dist=new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0]=0;
        long[] ways=new long[n];
        ways[0]=1;// One way to reach source (being at source)

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.distance,b.distance));
        pq.offer(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair current=pq.poll();
            int node=current.x;
            long distance=current.distance;
            if(distance>dist[node]) {
                continue;
            }
            for(Pair p: adj.get(node)){
                int nextNode=p.x;
                long edgeWeight=p.distance;
                long newDist=distance + edgeWeight;
                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    ways[nextNode] = ways[node]; // Reset ways count
                    pq.offer(new Pair(nextNode, newDist));
                }
                else if (newDist == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node])%mod;
                }
            }
        }
        return (int) ways[n - 1];
    }
}