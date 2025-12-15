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
    /**
     * Union-Find Solution (Optimal)
     * Time: O(k * α(m*n)), Space: O(m*n)
     * where k is number of operations
     */
    int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        List<Integer> res=new ArrayList<>();
        int k=operators.length;
        // 2D to 1D index conversion: (x,y) -> x * cols + y
        UnionFind uf=new UnionFind(rows*cols);
        boolean[][] grid=new boolean[rows][cols];
        int islands=0;
        for(int[] op:operators){
            int x=op[0], y=op[1];
            if(grid[x][y]){
                res.add(islands);
                continue;
            }
            grid[x][y]=true;
            islands++;
            int cellIndex=x*cols+y;
            for(int[] d:dir){
                int newRow=x+d[0];
                int newCol=y+d[1];
                if(newRow>=rows || newRow<0 || newCol>=cols || newCol<0) continue;
                if(grid[newRow][newCol]){
                    int adjacentIndex=newRow*cols+newCol;
                    if(uf.union(cellIndex, adjacentIndex)){
                        islands--;
                    }
                }
            }
            res.add(islands);
        }
        return res;
    }
}