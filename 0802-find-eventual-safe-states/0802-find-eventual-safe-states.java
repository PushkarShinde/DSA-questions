class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> res=new ArrayList<>();
        int[] indeg=new int[n];

        //reverse graph
        List<List<Integer>> rev = new ArrayList<>();
        for(int i=0;i<n;i++) rev.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            if(graph[i].length==0) continue;
            for(int v: graph[i]){
                rev.get(v).add(i);
            }
            indeg[i]=graph[i].length;//ulta indegree
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0) q.offer(i);
        }

        boolean[] safe = new boolean[n];
        while(!q.isEmpty()){
            int v=q.poll();
            safe[v]=true;
            for(int ch: rev.get(v)){
                indeg[ch]--;
                if(indeg[ch]==0) q.offer(ch);
            }
        }
        for(int i=0;i<n;i++){
            if(safe[i]) res.add(i);
        }
        return res;
    }
}