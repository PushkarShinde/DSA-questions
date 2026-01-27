class Solution {
    public boolean isWordExist(char[][] mat, String word) {
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0)==mat[i][j]){
                    if(dfs(i,j,mat,word,0)) return true;
                }
            }
        }
        return false;
    }
    private int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    private boolean dfs(int i, int j,char[][] mat, String word, int ind){
        int n=mat.length;
        int m=mat[0].length;
        if(ind==word.length()) return true;
        if(i<0 || j<0 || i>=n || j>=m || mat[i][j]!=word.charAt(ind)) 
            return false;
        char temp=mat[i][j];
        mat[i][j]='#';
        for(int[] d: dir){
            int dx=i+d[0], dy=j+d[1];
            if(dfs(dx,dy,mat,word,ind+1)){
                mat[i][j]=temp;
                return true;
            }
        }
        mat[i][j]=temp;
        return false;
    }
}