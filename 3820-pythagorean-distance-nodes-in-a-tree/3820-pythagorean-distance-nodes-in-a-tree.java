class Solution {
    Map<Integer, List<Integer>> adj;
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        adj=new HashMap<>();
        for(int[] i:edges){
            int u=i[0], v=i[1];
            adj.computeIfAbsent(u, k-> new ArrayList<>()).add(v); 
            adj.computeIfAbsent(v, k-> new ArrayList<>()).add(u); 
        }
        int res=0;
        for(int i:adj.keySet()){
            int[] d=new int[3];
            d[0]=bfs(i,x, n);
            d[1]=bfs(i,y, n);
            d[2]=bfs(i,z, n);
            if(d[0]==Integer.MAX_VALUE ||
            d[1]==Integer.MAX_VALUE ||
            d[2]==Integer.MAX_VALUE) continue;
            Arrays.sort(d);
            if((d[0]*d[0]+d[1]*d[1])==d[2]*d[2]) res++;
        }
        return res;
    }
    private int bfs(int src,int dest,int n){
        Queue<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[n+1];
        q.offer(src);
        vis[src]=true;
        int distance=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int u=q.poll();
                if(u==dest) return distance;
                for(int v:adj.getOrDefault(u, List.of())){
                    if(!vis[v]){
                        vis[v]=true;
                        q.offer(v);
                    }
                }
            }
            distance++;
        }
        return Integer.MAX_VALUE;
    }
}