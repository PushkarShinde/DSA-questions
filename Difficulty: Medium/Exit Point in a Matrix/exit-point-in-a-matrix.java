class Solution {
    List<Integer> res;
    int[][] mat;
    int n,m;
    boolean found;
    public List<Integer> exitPoint(int[][] mat) {
        this.mat=mat;
        this.n=mat.length;
        this.m=mat[0].length;
        
        found=false;
        res=new ArrayList<>();

        dfs(0,0,0);
        return res;
    }
    
    private int[] turn(int i, int j, int d){
        int[] ans=new int[2];
        if(d==1){
            ans[0]=i+1;
            ans[1]=j;
        }else if(d==2){
            ans[0]=i;
            ans[1]=j-1;
        }else if(d==3){
            ans[0]=i-1;
            ans[1]=j;
        }else{
            ans[0]=i;
            ans[1]=j+1;
        }
        return ans;
    }
    
    private void dfs(int i, int j, int d){
        if(found) return;
        
        if(mat[i][j]==1){
            mat[i][j]=0;
            int[] x=turn(i, j, (d+1)%4);
            
            if(x[1]>=m || x[0]>=n || x[1]<0 || x[0]<0) {
                res.add(i);
                res.add(j);
                found=true;
                return;
            }
            dfs(x[0], x[1], (d+1)%4);
        }else{
            int[] x=turn(i, j, d);
            if(x[1]>=m || x[0]>=n || x[1]<0 || x[0]<0) {
                res.add(i);
                res.add(j);
                found=true;
                return;
            }
            dfs(x[0], x[1], d);
        }
    }
}