class Solution {
    public int minSwaps(int[][] grid){
        int n=grid.length;
        List<Integer> trailing=new ArrayList<>();
        for(int i=0;i<n;i++){
            int tz=0;
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]!=0) break;
                tz++;
            }
            trailing.add(tz);
        }
        int round=0;
        for(int i=0;i<n;i++){
            if(trailing.get(i)>=n-i-1) continue;
            for(int j=i;j<n;j++){
                if(trailing.get(j)>=n-i-1){
                    round+=(j-i);
                    int val=trailing.get(j);
                    trailing.remove(j);
                    trailing.add(i, val);
                    break;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(trailing.get(i)<n-1-i) return -1;
        }
        return round;
    }
}