class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int t[]: times){
            int x=t[0], y=t[1], w=t[2];
            adj.get(x).add(new int[]{y,w});
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int u=cur[0], distance=cur[1];
            if(distance>dist[u]){
                continue;
            }
            for(int[] e: adj.get(u)){
                int v=e[0], w=e[1];
                int newDist=distance+w;
                if(newDist<dist[v]){
                    dist[v]=newDist;
                    pq.offer(new int[]{v,newDist});
                }
            }
        }
        int res=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            res=Math.max(dist[i], res);
        }
        return res;
    }
}