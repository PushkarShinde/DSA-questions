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
    public int removeStones(int[][] stones){
        int n=stones.length;
        UnionFind uf=new UnionFind(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int xi=stones[i][0], yi=stones[i][1];
                int xj=stones[j][0], yj=stones[j][1];
                if(xi==xj || yi==yj){
                    uf.union(i,j);
                }
            }
        }
        return n-uf.components;
    }
}