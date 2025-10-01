class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res=numBottles;
        int bot=numBottles;
        int ex=numExchange;
        while(bot/ex>0){
            int bottles=bot/ex;
            int rem=bot%ex;
            res+=bottles;
            bot=(bottles+rem);
        }
        return res;
    }
}