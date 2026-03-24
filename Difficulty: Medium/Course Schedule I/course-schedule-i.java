class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj=new HashMap<>();
        for(int[] e:prerequisites){
            int u=e[1];
            int v=e[0];
            adj.computeIfAbsent(u, k->new ArrayList<>()).add(v);
        }
        
        int[] indegree=new int[n];
        for(int[] p:prerequisites){
            int v=p[0];
            indegree[v]++;
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            int e=indegree[i];
            if(e==0) q.offer(i);
        }
        
        int nodes=0;
        while(!q.isEmpty()){
            int u=q.poll();
            nodes++;
            for(int v:adj.getOrDefault(u, new ArrayList<>())){
                indegree[v]--;
                
                if(indegree[v]==0){
                    q.offer(v);
                }
            }
        }
        
        return nodes==n;
    }
}