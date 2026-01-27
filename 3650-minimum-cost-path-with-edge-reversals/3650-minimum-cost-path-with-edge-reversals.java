class Solution {
    private List<int[]>[] adj;
    public int minCost(int n, int[][] edges) {
        adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] e:edges){
            int u=e[0], v=e[1], w=e[2];
            adj[u].add(new int[]{v,w});//forward
            adj[v].add(new int[]{u,2*w});//reverse
        }
        return dijkstra(n);
    }
    private int dijkstra(int n){
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
        //[cost, node]
        int[] minCost=new int[n];//hmara distance array
        Arrays.fill(minCost, Integer.MAX_VALUE);
        pq.offer(new int[]{0,0});
        minCost[0]=0;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int cost=cur[0];
            int node=cur[1];
            if(node==n-1) return cost;
            if(minCost[node]<cost) continue;//better path mil chuka h already
            for(int[] next:adj[node]){
                int v=next[0];
                int nextCost=next[1];
                int newCost=nextCost+cost;
                if(newCost<minCost[v]){
                    minCost[v]=newCost;
                    pq.offer(new int[]{newCost, v});
                }
            }
        }
        return (minCost[n-1]==Integer.MAX_VALUE)?-1:minCost[n-1];
    }
}