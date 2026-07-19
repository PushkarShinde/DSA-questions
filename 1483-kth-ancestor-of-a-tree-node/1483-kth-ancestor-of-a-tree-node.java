class TreeAncestor {
    int log=17;
    int[][] up;
    public TreeAncestor(int n, int[] parent) {
        up=new int[n][log];
        for(int i=0;i<n;i++){
            up[i][0]=parent[i];
        }

        for(int j=1;j<log;j++){
            for(int i=0;i<n;i++){
                int intermediate=up[i][j-1];
                if(intermediate!=-1){
                    up[i][j]=up[intermediate][j-1];
                }else{
                    up[i][j]=-1;
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int j=log-1;j>=0;j--){
            if((k&(1<<j))!=0){
                node=up[node][j]; 
                if(node==-1) return -1;
            }
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */