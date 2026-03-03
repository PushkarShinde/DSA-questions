class Solution {
    public int[][] merge(int[][] intervals) {
        int m=intervals.length;

        Arrays.sort(intervals, (x,y)->x[0]-y[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];

        List<int[]> res=new ArrayList<>();
        for(int i=0;i<m;i++){
            int[] cur=intervals[i];
            if(cur[0]<=end){
                end=Math.max(end, cur[1]);
            }else{
                res.add(new int[]{start, end});
                start=cur[0];
                end=cur[1];
            }
        }
        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][]);
    }
}