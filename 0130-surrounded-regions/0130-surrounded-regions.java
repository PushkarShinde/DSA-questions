class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis=new boolean[m][n];

        for(int i=0;i<m;i++){
            if(board[i][0]=='O' && !vis[i][0]) dfs(vis, board, i,0);
            if(board[i][n-1]=='O' && !vis[i][n-1]) dfs(vis, board, i,n-1);
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O' && !vis[0][j]) dfs(vis, board, 0,j);
            if(board[m-1][j]=='O' && !vis[m-1][j]) dfs(vis, board, m-1,j);
        }
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(board[i][j]=='O' && !vis[i][j]) board[i][j]='X';
            }
        }
    }
    int[][] dir={{0,-1}, {0,1}, {1,0}, {-1,0}};
    private void dfs(boolean[][] vis, char[][] board, int i, int j){
        int m=board.length;
        int n=board[0].length;
        if(i<0 || j<0 || i>m-1 || j>n-1 || vis[i][j] || board[i][j]=='X') return;
        vis[i][j]=true;
        for(int[] d: dir){
            int nx=i+d[0];
            int ny=j+d[1];
            dfs(vis, board, nx,ny);
        }
    }
}