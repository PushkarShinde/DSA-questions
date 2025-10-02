class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res=numBottles;
        int bot=numBottles;
        int ex=numExchange;
        while(bot/ex>0){
            int rem=bot-ex;
            res+=1;
            ex++;
            bot=rem+1;
        }
        return res;
    }
}