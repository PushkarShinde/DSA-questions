class Solution {
    List<int[]>[] adj;
    
    @SuppressWarnings("unchecked")
    public int countPaths(int V, int[][] edges) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)-> x[1]-y[1]);
        adj=new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int t=e[2];
            adj[u].add(new int[]{v,t});
            adj[v].add(new int[]{u,t});
        }
        
        int[] distance=new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0]=0;
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int u=cur[0];
            int time=cur[1];
            if(distance[u]>time) distance[u]=time;
            for(int[] child:adj[u]){
                int v=child[0];
                int t=child[1];
                int newTime=distance[u]+t;
                if(distance[v]>newTime){
                    distance[v]=newTime;
                    pq.offer(new int[]{v,newTime});
                }
            }
        }
        
        int count=dfs(0,V-1, distance[V-1]);
        return count;
    }
    
    private int dfs(int start, int dest, int minDist){
        if(start==dest && minDist==0) return 1;
        if(start>dest || minDist<0) return 0;
        int res=0;
        for(int[] child:adj[start]){
            int v=child[0];
            int t=child[1];
            res+=dfs(v, dest, minDist-t);
        }
        return res;
    }
}
