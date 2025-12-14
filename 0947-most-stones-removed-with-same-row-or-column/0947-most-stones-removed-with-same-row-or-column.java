class Solution {
    public int removeStones(int[][] stones){
        int n=stones.length;
        if(n==1) return 0;
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        int count1=0;
        int count2=0;
        for(int[] s:stones){
            int x=s[0], y=s[1];
            if(setX.contains(x) || setY.contains(y)) {
                count1++;
                // continue;
            }
            setX.add(x);
            setY.add(y);
        }
        setX.clear();
        setY.clear();
        for(int i=n-1;i>=0;i--){
            int x=stones[i][0], y=stones[i][1];
            if(setX.contains(x) || setY.contains(y)) {
                count2++;
                // continue;
            }
            setX.add(x);
            setY.add(y);
        }
        return Math.max(count1, count2);
    }
}