class Solution {
    /**
    Why 0-1 BFS?
    All transformed edge costs are only:
    0 or 1
    */
    List<int[]>[] adj;
    int n;
    int k;
    int target;
    int source;
    public int minimumThreshold(int n, int[][] edges, int source, int target, int k) {
        this.n=n;
        this.k=k;
        this.target=target;
        this.source=source;

        if(source==target) return 0;

        adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        int maxWeight=0;
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            adj[u].add(new int[]{v,w});
            adj[v].add(new int[]{u,w});
            maxWeight=Math.max(maxWeight, w);
        }

        if(!reachable()) return -1;

        int left=0, right=maxWeight;
        int ans=maxWeight;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(canReach(mid)){
                right=mid-1;
                ans=mid;
            }else{
                left=mid+1;
            }
        }

        return ans;
    }

    //0-1 BFS
    private boolean canReach(int threshold){
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Deque<Integer> dq=new ArrayDeque<>();
        dist[source]=0;
        dq.offerFirst(source);

        while(!dq.isEmpty()){
            int cur=dq.pollFirst();
            for(int[] e: adj[cur]){
                int v=e[0];
                int w=e[1];
                int cost=(w>threshold)?1:0;

                if(dist[cur]+cost<dist[v]){
                    dist[v]=dist[cur]+cost;
                    if(cost==0){
                        dq.offerFirst(v);
                    }else{
                        dq.offerLast(v);
                    }
                }
            }
        }
        return dist[target]<=k;
    }

    private boolean reachable(){
        Queue<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[n];
        q.offer(source);
        vis[source]=true;

        while(!q.isEmpty()){
            int cur=q.poll();

            if(cur==target){
                return true;
            }

            for(int[] e: adj[cur]){
                int v=e[0];
                if(!vis[v]){
                    vis[v]=true;
                    q.offer(v);
                }
            }
        }
        return false;
    }
}