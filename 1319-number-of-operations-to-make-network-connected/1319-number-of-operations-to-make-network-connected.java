class Solution {
    class UnionFind{
        int[] parent;
        int[] size;
        int components;
        UnionFind(int n){
            parent=new int[n];
            size=new int[n];
            components=n;
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        int find(int x){
            if(parent[x]!=x){
                return find(parent[x]);
            }
            return parent[x];
        }
        boolean union(int x, int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX==rootY){
                return false;
            }
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
    public int makeConnected(int n, int[][] connections) {
        int edges=n-1;
        int m=connections.length;
        if(edges>m) return -1;
        int count=0;
        UnionFind uf=new UnionFind(n);
        for(int[] c:connections){
            int x=c[0], y=c[1];
            if(!uf.union(x,y)) count++;
        }
        return uf.components-1;
    }
}