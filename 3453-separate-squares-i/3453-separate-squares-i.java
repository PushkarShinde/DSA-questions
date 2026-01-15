class Solution {
    public double separateSquares(int[][] squares) {
        double maxY=0.0;
        double totalArea=0.0;
        for(int[] s:squares){
            maxY=Math.max(maxY,(double)s[1]+s[2]);
            totalArea+=(double)s[2]*s[2];//side^2
        }
        double l=0, r=maxY;
        double precision=1e-5; 
        double target=totalArea/2.0;
        while(Math.abs(r-l)>precision){//for extra precision
            double mid=(double)l+(r-l)/2.0;
            if(areaBelow(mid,squares)>=target){
                r=mid;
            }else{
                l=mid;
            }
        }
        return l;
    }
    private double areaBelow(double h,int[][] sq){
        double area=0.0;
        for(int[] s:sq){
            int y=s[1], side=s[2];
            if(h<y) continue;
            else if(h>y){ 
                area+=(double)side*Math.min((double)side,h-y);
            }
        }
        return area;
    }
}