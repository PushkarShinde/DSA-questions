class Solution {
    public double separateSquares(int[][] squares) {
        int[][] square=squares.clone();
        Arrays.sort(square,(a,b)->{
            if(a[1]!=b[1]) return a[1]-b[1];
            return a[2]-b[2];
        });
        int n=square.length;
        double l=square[0][1];
        double r=square[n-1][1]+square[n-1][2];
        double totalArea=0.0;
        for(int[] s:squares){
            totalArea+=(long)s[2]*s[2];//side^2
        }
        double target=totalArea/2.0;
        for(int i=0;i<55;i++){//for extra precision
            double mid=l+(r-l)/2.0;
            if(areaBelow(mid,square)>=target){
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
            if(h<y) break;
            else if(h>=y+side){ 
                area+=(long)side*side;
            }else{
                area+=side*(h-y);
            }
        }
        return area;
    }
}