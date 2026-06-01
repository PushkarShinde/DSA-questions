class Solution {
    public int minimumCost(int[] cost) {
        int n=cost.length;
        int sum=0;
        Arrays.sort(cost);
        int i=n-1;
        while(i>=0){
            int cur=cost[i];
            int pre=(i>0)?cost[i-1]:0;
            sum+=cur+pre;
            i-=3;
        }

        return sum;
    }
}