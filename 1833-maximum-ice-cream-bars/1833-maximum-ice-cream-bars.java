class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res=0;
        for(int i:costs){
            coins-=i;
            if(coins<0) break;
            res++;
        }       
        return res;
    }
}