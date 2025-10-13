class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        // Map<Integer, List<Integer>> adj=new TreeMap<>();
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         int num=isConnected[i][j];
        //         if(num==1) adj.computeIfAbsent(i,k->new ArrayList<>()).add(j);
        //     }
        // }
        boolean[] vis=new boolean[n];
        int provinces=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected, vis, i, n);
                provinces++;
            }
        }
        return provinces;
    }
    private void dfs(int[][] isConnected, boolean[] vis, int i, int n){
        vis[i]=true;
        for(int j=0;j<n;j++){
            if(isConnected[i][j]==1 && !vis[j]){
                dfs(isConnected, vis, j, n);
            }
        }
    }
}