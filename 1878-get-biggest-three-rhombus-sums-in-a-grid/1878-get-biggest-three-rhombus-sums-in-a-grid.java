class Solution {
    public int[] getBiggestThree(int[][] grid) {
        TreeSet<Integer> set=new TreeSet<>((x,y)->y-x);
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                set.add(grid[i][j]);

                int k=1;
                while(true){
                    if(i+2*k>=n || j-k<0 || j+k>=m) break;
                    int sum=0;
                    int x=i, y=j;
                    for(int d=0;d<k;d++) sum+=grid[x+d][y+d];
                    for(int d=0;d<k;d++) sum+=grid[x+k+d][y+k-d];
                    for(int d=0;d<k;d++) sum+=grid[x+2*k-d][y-d];
                    for(int d=0;d<k;d++) sum+=grid[x+k-d][y-k+d];
                    set.add(sum);
                    k++;
                }
            }
        }

        int size=Math.min(set.size(), 3);
        int[] res=new int[size];
        int ind=0;
        for(int val:set){
            if(ind==size) break;
            res[ind]=val;
            ind++;
        }
        return res;
    }
}