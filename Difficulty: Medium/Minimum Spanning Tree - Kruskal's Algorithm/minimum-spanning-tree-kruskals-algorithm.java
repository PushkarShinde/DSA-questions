// User function Template for Java
class Solution {
    static class UnionFind{
        int[] parent;
        int[] size;
        int components;
        UnionFind(int n){
            this.parent=new int[n];
            this.size=new int[n];
            this.components=n;
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        
        int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        
        boolean union(int x, int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX==rootY) return false;
            if(size[rootX]<size[rootY]){
                parent[rootX]=rootY;
                size[rootY]+=size[rootX];
            }else{
                parent[rootY]=rootX;
                size[rootX]+=size[rootY];
            }
            components--;
            return true;
        }
    }
    static int kruskalsMST(int V, int[][] edges) {
        // List<List<int[]>> adj=new ArrayList<>();
        // for(int i=0;i<V;i++){
        //     adj.add(new ArrayList<>());
        // }
        // for(int[] e:edges){
        //     int u=e[0], v=e[1], w=e[2];
        //     adj.get(u).add(new int[]{v,w});
        //     // adj.get(v).add(new int[]{u,w});
        // }
        
        Arrays.sort(edges, (a,b)->{
            return Integer.compare(a[2],b[2]); 
        });
        int mst=0;
        UnionFind uf=new UnionFind(V);
        for(int[] e:edges){
            int u=e[0], v=e[1], w=e[2];
            if(uf.union(u,v)){
                mst+=w;
            }
        }
        return mst;
    }
}
