class Solution {
    public int minimumEffort(int[][] tasks) {
        int n=tasks.length;
        int l=0, r=Integer.MAX_VALUE;
        int res=0;
        Arrays.sort(tasks, (x,y)-> (y[1]-y[0])-(x[1]-x[0]));
        while(l<=r){
            int mid=l+(r-l)/2;
            if(solve(mid, tasks)){
                res=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
    private boolean solve(int eng, int[][] tasks){
        for(int[] i: tasks){
            int act=i[0];
            int min=i[1];
            if(min>eng) return false;
            eng-=act;
        }
        return true;
    }
}