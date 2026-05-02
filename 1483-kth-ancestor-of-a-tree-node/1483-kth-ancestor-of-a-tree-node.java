class TreeAncestor {
    int[][] up;
    int log;
    public TreeAncestor(int n, int[] parent) {
        this.log=0;
        while((1<<log)<=n) log++;

        this.up=new int[n][log];
        for(int i=0;i<n;i++){
            up[i][0]=parent[i];
        }

        for(int j=1;j<log;j++){
            for(int i=0;i<n;i++){
                if(up[i][j-1]!=-1){
                    up[i][j]=up[up[i][j-1]][j-1];
                }else{
                    up[i][j]=-1;
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int u=node;
        for(int j=0;j<log;j++){
            if(((1<<j)&k)!=0){
                u=up[u][j];
                if(u==-1) return -1;
            }
        }
        return u;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */