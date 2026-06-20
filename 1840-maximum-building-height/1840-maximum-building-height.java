class Solution {
    public int maxBuilding(int n, int[][] rest) {
        int m=rest.length;
        if(m==0) return n-1;

        List<int[]> list=new ArrayList<>();
        for(int[] r:rest){
            list.add(new int[]{r[0], r[1]});
        }
        list.add(new int[]{1,0});
        list.sort((x,y)->Integer.compare(x[0],y[0]));

        if(list.get(m)[0]!=n){
            list.add(new int[]{n,n-1});
            m++;
        }
        m++;

        for(int i=1;i<m;i++){
            int d=list.get(i)[0]-list.get(i-1)[0];
            list.get(i)[1]=Math.min(list.get(i-1)[1]+d, list.get(i)[1]);
        }
        for(int i=m-2;i>=0;i--){
            int d=list.get(i+1)[0]-list.get(i)[0];
            list.get(i)[1]=Math.min(list.get(i+1)[1]+d, list.get(i)[1]);
        }

        int res=0;
        for(int i=0;i<m-1;i++){
            int d=list.get(i+1)[0]-list.get(i)[0];
            int best=(d+list.get(i)[1]+list.get(i+1)[1])/2;
            res=Math.max(res, best);
        }

        return res;
    }
}