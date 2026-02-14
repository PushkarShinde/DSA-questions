class Solution {
    public double champagneTower(int poured, int qr, int qg) {
        double[][] cup=new double[102][102];
        cup[0][0]=(double)poured;
        for(int i=0;i<=qr;i++){
            for(int j=0;j<=i;j++){
                double q=(cup[i][j]-1.0)/2.0;
                if(q>0){
                    cup[i+1][j]+=q;
                    cup[i+1][j+1]+=q;
                }
            }
        }
        return Math.min(1, cup[qr][qg]);
    }
}