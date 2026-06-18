class Solution {
    public int findCoverage(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        boolean[] left=new boolean[n];
        boolean[] up=new boolean[m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    up[j]=true;
                    left[i]=true;
                    continue;
                }
                
                boolean down=false;
                for(int k=i+1;k<n;k++){
                    if(mat[k][j]==1){
                        down=true;
                        break;
                    }
                }

                boolean right=false;
                for(int  k=j+1;k<m;k++){
                    if(mat[i][k]==1){
                        right=true;
                        break;
                    }
                }
                
                if(left[i]) count++;
                if(up[j]) count++;
                if(right) count++;
                if(down) count++;
            }
        }
        
        return count;
    }
}