class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] res=new int[m][n];
        //lower triangle ---the first diagonal is starting from 00 and the row is incresing for each diagonal start index
        for(int row=0;row<m;row++){
            List<Integer> list=new ArrayList<>();
            int col=0;
            int r=row;
            while(row<m && col<n){
                int num=grid[row][col];
                list.add(num);
                row++;
                col++;
            }
            Collections.sort(list);
            row--; col--;
            int i=0;
            while(row>=r && col>=0){
                res[row][col]=list.get(i);
                i++;
                row--; col--;
            }
            row=r;
        }
        
        //Upper triangle ---the first diagonal is starting from 01 and the col is incresing for each diagonal start index
        for(int col=1;col<n;col++){
            List<Integer> list=new ArrayList<>();
            int row=0;
            int c=col;
            while(row<m && col<n){
                int num=grid[row][col];
                list.add(num);
                row++;
                col++;
            }
            Collections.sort(list, (a,b)->b-a);
            row--; col--;
            int i=0;
            while(row>=0 && col>=c){
                res[row][col]=list.get(i);
                i++;
                row--; col--;
            }
            col=c;
        }
        return res;
    }
}