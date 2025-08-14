// User function Template for Java

class Solution {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public int[][] searchWord(char[][] grid, String word) {
        int m=grid.length;
        int n=grid[0].length;
        List<int[]> ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==word.charAt(0) && searchFrom(grid, i, j, word)){
                    ans.add(new int[]{i, j});
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
    private static boolean searchFrom(char[][] grid, int i, int j, String word){
        int n = grid.length;
        int m = grid[0].length;
        int len = word.length();
        
        for(int dir=0;dir<8;dir++){
            int nx=i, ny=j;
            int k;
            for(k=0;k<len;k++){
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || grid[nx][ny] != word.charAt(k)) break;
                nx+=dx[dir];
                ny+=dy[dir];
            }
            if(k==len) return true;
        }
        return false;
    }
}