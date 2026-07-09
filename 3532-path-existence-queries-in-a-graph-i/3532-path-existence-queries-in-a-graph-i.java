class Solution {
    int[] parent, rank;
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] qu) {
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        for(int i=0;i<n-1;i++){
            if(nums[i+1]-nums[i]<=maxDiff) union(i,i+1);
        }

        int m=qu.length;
        boolean[] res=new boolean[m];
        for(int i=0;i<m;i++){
            int u=qu[i][0];
            int v=qu[i][1];

            if(u==v){
                res[i]=true;
                continue;
            }

            res[i]=query(u,v);
        }

        return res;
    }

    private int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y){
        int rootX=find(x);
        int rootY=find(y);

        if(rootX==rootY) return;

        if(rank[rootX]<rank[rootY]){
            parent[rootX]=rootY;
        }else if(rank[rootX]>rank[rootY]){
            parent[rootY]=rootX;
        }else{
            parent[rootY]=rootX;
            rank[rootX]++;
        }
    }

    private boolean query(int x, int y){
        return find(x)==find(y);
    }
}