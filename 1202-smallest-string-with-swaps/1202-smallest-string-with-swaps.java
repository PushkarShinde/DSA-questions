class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n=s.length();
        UnionFind uf=new UnionFind(n);

        for(List<Integer> pair: pairs){
            uf.union(pair.get(0), pair.get(1));
        }

        //root of the components to characters
        Map<Integer, PriorityQueue<Character>> map=new HashMap<>();

        for(int i=0;i<n;i++){
            int root=uf.find(i);

            map.computeIfAbsent(root, k-> new PriorityQueue<>()).add(s.charAt(i));
        }

        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++){
            int root=uf.find(i);

            res.append(map.get(root).poll());
        }

        return res.toString();
    }

    class UnionFind{
        int n;
        int[] parent;
        int[] rank;

        UnionFind(int n){
            this.n=n;
            parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
            
            rank=new int[n];
        }

        void union(int a, int b){
            int rootA=find(a);
            int rootB=find(b);

            if(rank[rootA]>rank[rootB]){
                parent[rootB]=rootA;
            }else if(rank[rootA]<rank[rootB]){
                parent[rootA]=rootB;
            }else{
                rank[rootA]++;
                parent[rootB]=rootA;
            }
        }

        int find(int a){
            if(a!=parent[a]){
                a=find(parent[a]);
            }
            return parent[a];
        }
    }
}