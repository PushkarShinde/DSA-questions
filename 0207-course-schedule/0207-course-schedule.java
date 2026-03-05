class Solution {
    private List<Integer>[] adj;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            adj[u].add(v);
        }

        Queue<Integer> q=new LinkedList<>();
        int[] indegree=new int[numCourses];
        for(int u=0;u<numCourses;u++){
            for(int v:adj[u]){
                indegree[v]++;
            }
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int nums=0;
        while(!q.isEmpty()){
            int u=q.poll();
            nums++;
            for(int v:adj[u]){
                indegree[v]--;
                if(indegree[v]==0){
                    q.offer(v);
                }
            }
        }
        return nums==numCourses;
    }
}