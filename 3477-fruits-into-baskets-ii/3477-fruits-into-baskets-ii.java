class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        int[][] place=new int[n][2];
        boolean[] taken=new boolean[n];
        // Arrays.fill(taken, false);
        for(int i=0;i<n;i++){
            place[i][0]=baskets[i];
            for(int j=0;j<n;j++){
                if(taken[j]==false && fruits[j]<=place[i][0]){
                    place[i][1]=fruits[j];
                    taken[j]=true;
                    break;
                }
            }
        }
        int count=0;
        for(boolean i: taken){
            if(i==false) count++;
        }
        return count;
    }
}