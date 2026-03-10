class Solution {
    private char[][] board;
    private String word;
    private int n;
    private int m;
    private boolean[][] vis;
    public boolean exist(char[][] board, String word) {
        this.n=board.length;
        this.m=board[0].length;
        this.board=board;
        this.word=word;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    vis=new boolean[n][m];
                    vis[i][j]=true;
                    if(dfs(i,j,1)) return true;
                }
            }
        }
        return false;
    }

    private int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
    private boolean dfs(int i, int j, int ind){
        if(ind==word.length()) return true;
        for(int[] d:dir){
            int ni=i+d[0];
            int nj=j+d[1];
            if(ni<0 || nj<0 || ni>=n || nj>=m || vis[ni][nj]) continue;
            if(board[ni][nj]==word.charAt(ind)){
                vis[ni][nj]=true;
                if(dfs(ni,nj,ind+1)) return true;
                vis[ni][nj]=false;
            }
        }
        return false;
    }
}