class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] pre=new int[n][m][2];
        int count=0;

        if(grid[0][0]=='X'){
            pre[0][0][0]=1;
            pre[0][0][1]=1;
        }else if(grid[0][0]=='Y'){
            pre[0][0][0]=-1;
        }

        for(int i=1;i<n;i++){
            int add=0;
            if(grid[i][0]=='X') add++;
            else if(grid[i][0]=='Y') add--;

            pre[i][0][0]=pre[i-1][0][0]+add;
            if(grid[i][0]=='X' || pre[i-1][0][1]==1) pre[i][0][1]=1;
        }
        for(int j=1;j<m;j++){
            int add=0;
            if(grid[0][j]=='X') add++;
            else if(grid[0][j]=='Y') add--;

            pre[0][j][0]=pre[0][j-1][0]+add;
            if(grid[0][j]=='X' || pre[0][j-1][1]==1) pre[0][j][1]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                int add=0;
                if(grid[i][j]=='X') add++;
                else if(grid[i][j]=='Y') add--;

                if(i>0 && j>0){
                    pre[i][j][0]=pre[i-1][j][0]+pre[i][j-1][0]+add-pre[i-1][j-1][0];
                }else if(i==0){
                    pre[i][j][0]=pre[i][j-1][0]+add;
                }else if(j==0){
                    pre[i][j][0]=pre[i-1][j][0]+add;
                }
                if(grid[i][j]=='X' || pre[i-1][j-1][1]==1 || 
                    pre[i-1][j][1]==1 || pre[i][j-1][1]==1) pre[i][j][1]=1;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pre[i][j][0]==0 && pre[i][j][1]==1) count++;
            }
        }
        return count;
    }
}