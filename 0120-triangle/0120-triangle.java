class Solution {
    // private int[][] dir={{1,0},{1,1}};
    // int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        List<List<Integer>> tri= new ArrayList<>();
        for(int i=0;i<m;i++){
            tri.add(new ArrayList<>(triangle.get(i)));
        }
        // dp=new int[m][m];
        // for(int i=0;i<m;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return solve(triangle, 0,0);
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<tri.get(i).size();j++){
                int left=tri.get(i+1).get(j)+tri.get(i).get(j);
                int right=tri.get(i+1).get(j+1)+tri.get(i).get(j);
                int val=Math.min(left, right);
                tri.get(i).set(j,val);
            }
        }
        return tri.get(0).get(0);
    }
    /*
    Memoization caused TLE...
    private int solve(List<List<Integer>> tri, int i, int j){
        int m=tri.size();
        if(i==m-1) return tri.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        int minSum=Integer.MAX_VALUE;
        int num=tri.get(i).get(j);
        for(int[] d:dir){
            int x=i+d[0], y=j+d[1];
            if(x<0 || y<0 || x>=m || y>=tri.get(x).size()) continue;
            minSum=Math.min(minSum, num+solve(tri, x, y));
        }
        return dp[i][j]=minSum;
    }
    */
}