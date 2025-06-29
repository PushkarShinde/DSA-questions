class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int maxOne=0;
        int index=0;
        for(int i=0;i<m;i++){
            int cnt=0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    cnt++;
                }
            }
            if(cnt>maxOne){
                maxOne=cnt;
                index=i;
            }
        }
        return new int[]{index,maxOne}; 
    }
}