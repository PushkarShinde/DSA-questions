class Solution {
    public int countCoveredBuildings(int length, int[][] buildings) {
        Map<Integer, List<Integer>> mapX=new HashMap<>();
        Map<Integer, List<Integer>> mapY=new HashMap<>();
        for(int i[]:buildings){
            int x=i[0], y=i[1];
            mapY.computeIfAbsent(y, k-> new ArrayList<>()).add(x);
            mapX.computeIfAbsent(x, k-> new ArrayList<>()).add(y);
        }
        for(List<Integer> list:mapY.values()){
            Collections.sort(list);
        }
        for(List<Integer> list:mapX.values()){
            Collections.sort(list);
        }
        int count=0;
        for(int[] b: buildings){
            int x=b[0], y=b[1];
            List<Integer> row=mapY.get(y);
            int n=row.size();
            int xi=Collections.binarySearch(row,x);
            boolean left=xi>0; 
            boolean right=xi<(n-1); 
            if(!(left && right)) continue;

            List<Integer> col=mapX.get(x);
            int m=col.size();
            int yi=Collections.binarySearch(col,y);
            boolean upper=yi>0;
            boolean lower=yi<(m-1);
            if(upper && lower) count++;
        }
        return count;
    }
}