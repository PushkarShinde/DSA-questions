class Solution {
    public int minOperations(int[][] grid, int x) {
        int n=grid.length;
        int m=grid[0].length;
        if(n==1 && m==1) return 0;
        List<Integer> val=new ArrayList<>();
        int maxVal=0;
        for(int[] gr:grid){
            for(int g:gr){
                val.add(g);
            }
        }

        Collections.sort(val);
        int res=0;
        int med=val.get(val.size()/2);
        for(int v: val){
            if(v%x!=med%x) return -1;
            res+=Math.abs(med-v)/x;
        }
        return res;
    }
}