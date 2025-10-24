class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p: prerequisites){
            int x=p[0];
            int y=p[1];
            adj.get(y).add(x);
        }
        boolean[] vis=new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(i,stack,inStack, vis, adj)){
                    return new int[]{};
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            res[i]=stack.pop();
        }
        return res;
    }
    private boolean dfs(int i, Stack<Integer> stack, boolean[] inStack, boolean[] vis,List<List<Integer>> adj){
        vis[i]=true;
        inStack[i]=true;
        for(int ch: adj.get(i)){
            if(inStack[ch]) return true;
            if(!vis[ch] && dfs(ch,stack,inStack, vis,adj)) return true;
        }
        inStack[i]=false;
        stack.push(i);
        return false;
    }
}