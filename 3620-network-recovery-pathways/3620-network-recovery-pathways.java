class Solution {
    // private int maxScore;
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n=online.length;
        
        int maxScore=0;
        List<int[]>[] adj=new ArrayList[n]; 
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int c=e[2];
            adj[u].add(new int[]{v,c});
            maxScore=Math.max(maxScore,c);
        }

        int res=-1;
        int low=0;
        int high=maxScore;
        while(low<=high){
            int mid=low+((high-low)>>1);
            if(reach(n,adj,online, k,mid)){
                low=mid+1;
                res=mid;
            }else{
                high=mid-1;
            }
        }

        return res;
    }

    private boolean reach(int n,List<int[]>[] adj,boolean[] online,long k, int minScore){
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE/2);
        dist[0] = 0;

        PriorityQueue<long[]> q=new PriorityQueue<>((x,y)-> Long.compare(x[1],y[1]));
        q.offer(new long[]{0,0});//{node, total score so far}

        while(!q.isEmpty()){
            long[] cur=q.poll();
            int u=(int)cur[0];
            long curCost=cur[1];

            if(u==n-1){
                return curCost<=k;
            }

            if(curCost>dist[u]) continue;

            for(int[] next:adj[u]){
                int v=next[0];
                int cost=next[1];

                if(cost<minScore || !online[v]) continue;

                if(curCost+cost<dist[v]){
                    dist[v]=curCost+cost;
                    q.offer(new long[]{v,dist[v]});
                }
            }
        }

        return false;
    }
}