class Solution {
    public int numberOfPairs(int[][] points) {
        int n=points.length;
        Arrays.sort(points, (a,b)->{
            if(a[0]==b[0]) return b[1]-a[1]; //decending
            return a[0]-b[0];
        });
        int pairs=0;
        for(int i=0;i<n;i++){
            int ix=points[i][0], iy=points[i][1];
            int maxy=Integer.MIN_VALUE;
            for(int j=i+1;j<n;j++){
                int jx=points[j][0], jy=points[j][1];
                if(jy>iy) continue;//lower right chahiye n bs

                // boolean valid=true;
                // for(int k=i+1;k<j;k++){
                //     int kx=points[k][0], ky=points[k][1];
                //     if(ix<=kx && kx<=jx && iy>=jy && ky>=jy){
                //         valid=false;
                //         break;
                //     }
                // }
                
                if(jy>maxy){
                    maxy=jy;
                    pairs++;
                }
            }
        }
        return pairs;
    }
}