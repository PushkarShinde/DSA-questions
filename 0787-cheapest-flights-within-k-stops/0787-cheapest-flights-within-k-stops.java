class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] flight: flights){
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,src,0});// cost=0, city=src, stops=0

        //minCost[city][stops] = minimum cost to reach city with exactly 'stops' stops
        int[][] cost=new int[n][k+2];
        for(int i=0;i<n;i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
        cost[src][0]=0;

        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int curCost=cur[0], city=cur[1], stops=cur[2];
            if(city==dst) return curCost; 
            if(stops>k) continue;
            for(int[] nei: adj[city]){
                int nextCity=nei[0], price=nei[1];
                int newCost=curCost+price;
                int newStops=stops+1;
                if(newCost<cost[nextCity][newStops]){
                    cost[nextCity][newStops]=newCost;
                    pq.offer(new int[]{newCost, nextCity, newStops});
                }
            }
        }
        return -1;
    }
}