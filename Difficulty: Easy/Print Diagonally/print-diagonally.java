class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        int n=mat.length;
        int m=mat[0].length;
        ArrayList<Integer> res=new ArrayList<>();
        for(int j=0;j<m;j++){
            int x=0;
            int y=j;
            int num=0;
            while(x<n && y>=0){
                num=mat[x][y];
                res.add(num);
                x++; y--;
            }
        }
        for(int i=1;i<n;i++){
            int x=i;
            int y=m-1;
            int num=0;
            while(x<n && y>=0){
                num=mat[x][y];
                res.add(num);
                x++; y--;
            }
        }
        return res;
    }
}
