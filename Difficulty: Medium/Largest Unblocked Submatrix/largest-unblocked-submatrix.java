class Solution {
    Set<Integer> col;
    Set<Integer> row;
    int n, m;
    public int largestArea(int n, int m, int[][] arr) {
        this.n=n;
        this.m=m;
        
        col=new HashSet<>();
        row=new HashSet<>();
        for(int[] a:arr){
            int x=a[0], y=a[1];
            col.add(y);
            row.add(x);
        }
        
        int maxR=0;
        int maxC=0;
        int cur=0;
        for(int i=1;i<=n;i++){
            if(!row.contains(i)){
                cur++;
                maxR=Math.max(maxR, cur);
            }else{
                cur=0;
            }
        }
        cur=0;
        for(int j=1;j<=m;j++){
            if(!col.contains(j)){
                cur++;
                maxC=Math.max(maxC, cur);
            }else{
                cur=0;
            }
        }
        
        return maxC*maxR;
    }
    
    // int[][] dir={{0,1},{1,0}};
    // private int dfs(int i, int j){
    //     vis[i][j]=true;
        
    //     int res=1;
    //     for(int[] d:dir){
    //         int nx=i+d[0];
    //         int ny=j+d[1];
            
    //         if(nx>n || ny>m || vis[nx][ny] || col.contains(ny) || row.contains(nx)){
    //             continue;
    //         }
            
    //         res+=dfs(nx,ny);
    //     }
        
    //     return res;
    // }
}