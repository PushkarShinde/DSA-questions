class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] hor=new int[n][m];
        int[][] ver=new int[n][m];
        long total=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                total+=grid[i][j];
            }
        }

        for(int j=0;j<m;j++){
            hor[0][j]=grid[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                hor[i][j]=grid[i][j]+hor[i-1][j];
            }
        }

        for(int i=0;i<n;i++){
            ver[i][0]=grid[i][0];
        }
        for(int j=1;j<m;j++){
            for(int i=0;i<n;i++){
                ver[i][j]=grid[i][j]+ver[i][j-1];
            }
        }

        for(int i=0;i<n-1;i++){
            long pre=0;
            for(int j=0;j<m;j++){
                pre+=hor[i][j];
            }
            if(pre==total-pre) return true; 
        }
        for(int j=0;j<m-1;j++){
            long pre=0;
            for(int i=0;i<n;i++){
                pre+=ver[i][j];
            }
            if(pre==total-pre) return true; 
        }
        return false;
    }
}