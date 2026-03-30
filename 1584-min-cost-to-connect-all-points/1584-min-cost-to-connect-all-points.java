class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        //1.adj prepare
        List<int[]>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x=Math.abs(points[i][0]-points[j][0]);
                int y=Math.abs(points[i][1]-points[j][1]);
                adj[j].add(new int[]{i,x+y});
                adj[i].add(new int[]{j,x+y});
            }
        }

        boolean[] vis=new boolean[n];
        int sum=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->x[1]-y[1]);
        pq.offer(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int u=cur[0];
            int distance=cur[1];
            if(vis[u]) continue;
            vis[u]=true;
            sum+=distance;

            for(int[] next:adj[u]){
                int nextNode=next[0];
                int nextDist=next[1];

                if(!vis[nextNode]){
                    pq.offer(new int[]{nextNode, nextDist});
                }
            }
        }

        return sum;
    }
}