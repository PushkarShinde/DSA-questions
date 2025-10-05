class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();
        int m=heights.length;
        int n=heights[0].length;
        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];
        
        for(int i=0;i<m;i++){
            dfs(heights, pacific, i, 0, heights[i][0]);//left
            dfs(heights, atlantic, i, n-1, heights[i][n-1]);//riight
        }
        for(int i=0;i<n;i++){
            dfs(heights, pacific, 0, i, heights[0][i]);//top
            dfs(heights, atlantic, m-1, i, heights[m-1][i]);//bottom
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(List.of(i,j));
                }
            }
        }
        return res;
    }
    private void dfs(int[][] h, boolean[][] vis, int r, int c, int preh){
        int m=h.length, n=h[0].length;
        if(r < 0 || c < 0 || r >= m || c >= n || vis[r][c] || h[r][c] < preh){
            return;
        }
        vis[r][c]=true;
        int[][] dir= {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] d: dir){
            dfs(h,vis,r+d[0],c+d[1], h[r][c]);
        }
    }
}