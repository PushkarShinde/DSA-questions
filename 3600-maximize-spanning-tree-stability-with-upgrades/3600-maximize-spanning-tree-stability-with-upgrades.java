class Solution {
    class DSU{
        int[] rank, parent;
        int components;
        DSU(int n){
            this.rank=new int[n];
            this.parent=new int[n];
            this.components=0;
            for(int i=0;i<n;i++){
                rank[i]=1;
                parent[i]=i;
            }
        }

        public int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX==rootY) return false;
            if(rank[rootX]<rank[rootY]){
                parent[rootX]=rootY;
            }else if(rank[rootX]>rank[rootY]){
                parent[rootY]=rootX;
            }else{
                parent[rootY]=rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    int[][] edges;
    int n;
    int k;
    public int maxStability(int n, int[][] edges, int k) {
        this.edges=edges;
        this.k=k;
        this.n=n;
        DSU dsu=new DSU(n);

        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            int s=edge[2];
            int m=edge[3];
            if(m==1){
                if(dsu.find(u)==dsu.find(v)) return -1;
                dsu.union(u,v);
            }
        }

        int res=-1;
        int l=1, r=2*(int)(1e5);
        while(l<=r){
            int mid=l+(r-l)/2;
            if(valid(mid)){
                res=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return res;
    }

    //kya mai ek aisa MST bana sakta hu jiski stability=mid ho
    private boolean valid(int stability){
        // Arrays.sort(edges, (x,y)->x[2]-y[2]);
        DSU dsu=new DSU(n);
        List<int[]> upgrade=new ArrayList<>();
        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            int s=edge[2];
            int m=edge[3];
            if(m==1){
                if(s<stability) return false;
                dsu.union(u,v);
            }else{
                if(s>=stability) dsu.union(u,v);
                else if(2*s>=stability){
                    upgrade.add(new int[]{u,v});
                }
            }
        }

        int remaining=k;
        for(int[] up:upgrade){
            int x=up[0];
            int y=up[1];
            if(dsu.find(x)!=dsu.find(y)){
                if(remaining<=0) return false;
                dsu.union(x,y);
                remaining--;
            }
        }

        int root=dsu.find(0);
        for(int i=1;i<n;i++){
            if(dsu.find(i)!=root) return false;
        }
        return true;
    }
}