class Solution {
    class DSU {
        int[] parent;
        int[] rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
        void reset(int x) {
            parent[x] = x;
            rank[x] = 0;
        }
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a,b)-> Integer.compare(a[2],b[2]));
        DSU uf=new DSU(n);
        uf.union(0,firstPerson);
        int i=0;
        while(i<meetings.length){
            int time=meetings[i][2];
            List<int[]> cur=new ArrayList<>();
            while(i<meetings.length && meetings[i][2]==time){
                int x=meetings[i][0];
                int y=meetings[i][1];
                cur.add(new int[]{x,y});
                uf.union(x,y);
                i++;
            }
            for(int[] c:cur){
                int x=c[0], y=c[1];
                if(uf.find(x)!=uf.find(0)){
                    uf.reset(x);
                    uf.reset(y);
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int j=0;j<n;j++){
            if(uf.find(j)==uf.find(0)){
                res.add(j);
            }
        }
        return res;
    }
}