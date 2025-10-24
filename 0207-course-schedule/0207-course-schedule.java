class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p:  prerequisites){
            int x=p[0];
            int y=p[1];
            // adj.computeIfAbsent(x,k->new ArrayList<>()).add(y);
            adj.get(x).add(y);
        }
        boolean[] vis=new boolean[numCourses];
        boolean[] stack=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(dfs(i,stack,vis, adj)) return false;
        }
        return true;
    }
    private boolean dfs(int i, boolean[] stack, boolean[] vis,List<List<Integer>> adj){
        stack[i]=true;
        for(int ch: adj.get(i)){
            if (stack[ch]) return true;//cycle
            if(!vis[ch] && dfs(ch,stack,vis,adj)) return true;
        }
        stack[i]=false;//remove from recursive stack
        vis[i]=true;
        return false;
    }
}