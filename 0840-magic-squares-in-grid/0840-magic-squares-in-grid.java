class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(m<3 && n<3) return 0;
        int count=0;
        for(int i=0;i<m-2;i++){
            for(int j=0;j<n-2;j++){
                if(grid[i+1][j+1]!=5) continue;
                boolean[] unique=new boolean[10];  
                boolean valid=true; 
                int[] row=new int[3];
                int[] col=new int[3];
                int diag1=0, diag2=0;
                for(int x=0;x<3;x++){
                    for(int y=0;y<3;y++){
                        int v=grid[i+x][j+y];
                        if(v<1 || v>9 || unique[v]){
                            valid=false;
                            break;
                        }
                        unique[v]=true;
                        row[x]+=v; col[y]+=v;
                        if(x==y) diag1+=v;
                        if(x+y==2) diag2+=v;
                    }
                }
                if(!valid) continue;
                if(row[0]==15 && row[1]==15 && row[2]==15 &&
                    col[0]==15 && col[1]==15 && col[2]==15 &&
                    diag1==15 && diag2==15){
                    count++;
                }
            }
        }
        return count;
    }
}