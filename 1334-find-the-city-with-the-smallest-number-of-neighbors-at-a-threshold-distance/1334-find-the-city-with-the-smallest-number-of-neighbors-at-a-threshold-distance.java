class Solution {
    //Dijkstra
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]: edges){
            int x=e[0], y=e[1], w=e[2];
            adj.get(x).add(new int[]{y,w});
            adj.get(y).add(new int[]{x,w});
        }
        int resultCity=-1;
        int minNeighbours=n;
        for(int city=0;city<n;city++){
            int reachable=dijkstra(city, n, adj, distanceThreshold);
            if(minNeighbours>=reachable){
                minNeighbours=reachable;
                resultCity=city;
            }
        }
        return resultCity;
    }
    private int dijkstra(int src, int n, List<List<int[]>> adj, int threshold){
        int[] dist=new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{src,0});
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int x=cur[0], distance=cur[1];
            if(distance>dist[x]){
                continue;
            }
            for(int[] v: adj.get(x)){
                int y=v[0], w=v[1];
                int newDist=distance+w;
                if(newDist<dist[y]){
                    dist[y]=newDist;
                    pq.offer(new int[]{y,newDist});
                }
            }
        }
        int count=0;
        //count reachable cities withing threshold
        for(int i=0;i<n;i++){
            if(i!=src && dist[i]<=threshold){
                count++;
            }   
        }
        return count;
    }
    /*
    Approach:
        This is a perfect problem for Floyd-Warshall algorithm because:
        -We need distances between all pairs of cities
        -Graph is small (n ≤ 100)
        -Need to find reachable cities within a threshold for each city

        Alternative Approaches:
        -Floyd-Warshall: O(n³) - Best for small dense graphs
        -Dijkstra from each city: O(n × (E log V)) - Good for sparse graphs
    */
}