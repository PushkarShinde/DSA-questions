class Solution {
    class DSU{
        int[] rank;
        int[] parent;
        int n;
        int components;
        DSU(int n){
            this.n=n;
            rank=new int[n+1];
            parent=new int[n+1];
            for(int i=0;i<=n;i++){
                parent[i]=i;
            }
            components=n;
        }

        int find(int x){
            if(x!=parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y){
            int rootX=find(x);
            int rootY=find(y);
            if (rootX == rootY) return;

            if(rank[rootX]>rank[rootY]){
                parent[rootY]=rootX;
            }else if(rank[rootX]<rank[rootY]){
                parent[rootX]=rootY;
            }else{
                parent[rootY]=rootX;
                rank[rootX]++;
            }
            components--;
        }

        int comps(){
            return components;
        }
    } 
    public int removeStones(int[][] stones) {
        int n=stones.length;
        DSU dsu=new DSU(n);
        
        for(int i=0;i<n;i++){
            int[] a=stones[i];
            int x=a[0];
            int y=a[1];
            for(int j=i+1;j<n;j++){
                int[] b=stones[j];
                int p=b[0];
                int q=b[1];

                if(p==x || q==y) dsu.union(i,j);
            }
        }
        return n-dsu.comps();
    }
}