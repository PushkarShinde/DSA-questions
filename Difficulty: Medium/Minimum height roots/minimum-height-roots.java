class Solution {
    @SuppressWarnings("unchecked")
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> res=new ArrayList<>();
        if(V<=2){
            for(int i=0;i<V;i++){
                res.add(i);
            }
            return res;
        }
        
        List<Integer>[] adj=new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        
        int[] indegree=new int[V];
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            indegree[u]++;
            indegree[v]++;
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==1) q.offer(i);
        }
        while(!q.isEmpty() && V>2){
            int size=q.size();
            V-=size;
            while(size-->0){
                int u=q.poll();
                for(int v:adj[u]){
                    indegree[v]--;
                    if(indegree[v]==1) q.offer(v);
                }
            }
        }
        
        while(!q.isEmpty()){
            res.add(q.poll());
        }
        
        return res;
    }
}