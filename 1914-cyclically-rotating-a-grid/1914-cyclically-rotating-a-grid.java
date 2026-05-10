class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int layer=Math.min(n/2, m/2);
        for(int i=0;i<layer;i++){
            solve(grid, i, i, k);
        }
        return grid;
    }
    private void solve(int[][] grid, int a, int b, int k){
        int n=grid.length;
        int m=grid[0].length;
        List<Integer> list=new ArrayList<>();
        
        for(int i=b;i<m-b;i++){
            list.add(grid[a][i]);
        }
        for(int i=a+1;i<n-a;i++){
            list.add(grid[i][m-1-b]);
        }
        for(int i=m-2-b;i>=b;i--){
            list.add(grid[n-1-a][i]);
        }
        for(int i=n-2-a;i>a;i--){
            list.add(grid[i][b]);
        }

        k%=list.size();
        for(int i=0;i<k;i++){
            int num=list.get(0);
            list.remove(0);
            list.add(num);
        }

        int ind=0;
        for(int i=b;i<m-b;i++){
            grid[a][i]=list.get(ind);
            ind++;
        }
        for(int i=a+1;i<n-a;i++){
            grid[i][m-1-b]=list.get(ind);
            ind++;
        }
        for(int i=m-2-b;i>=b;i--){
            grid[n-1-a][i]=list.get(ind);
            ind++;
        }
        for(int i=n-2-a;i>a;i--){
            grid[i][b]=list.get(ind);
            ind++;
        }
    }
}