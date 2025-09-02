class Solution {
    public int numberOfPairs(int[][] points) {
        // Arrays.sort(points, (a,b)-> {
        //     if(a[0]!=b[0]) return a[0]-b[0];
        //     return a[1]-b[1];
        // });
        int pairs=0;
        int n=points.length;
        for(int i=0;i<n;i++){
            int xi=points[i][0], yi=points[i][1]; 
            for(int j=0;j<n;j++){
                if(i==j) continue;
                int xj=points[j][0], yj=points[j][1];
                if(xi<=xj && yi>=yj){
                    boolean valid=true;
                    for(int k=0;k<n;k++){
                        if(k==i || k==j) continue;
                        int kx=points[k][0], ky=points[k][1];
                        if(kx>=xi && kx<=xj && ky>=yj && ky<=yi){
                            valid=false;
                            break;
                        }
                    }
                    if(valid) pairs++;
                }
            }
        }
        return pairs;
    }
}