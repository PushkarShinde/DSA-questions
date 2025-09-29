class Solution {
    int[][] mem=new int[51][51];
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        for(int i=0;i<51;i++){
            Arrays.fill(mem[i], -1);
        }
        return solve(values, 0,n-1);
    }
    private int solve(int[] values, int i, int j){
        if(j-i+1<3) return 0;
        if(mem[i][j]!=-1){
            return mem[i][j];
        }
        int res=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int wt=values[i]*values[j]*values[k] + 
                    solve(values, i,k) +
                    solve(values, k, j);
            res=Math.min(res,wt);
        }
        return mem[i][j]=res;
    }
}