class Solution {
    public int numberOfWays(int n, int x) {
        // List<Integer> powers=new ArrayList<>();
        // int num=1;
        // while(true){
        //     int power=1;
        //     for(int i=0;i<x;i++){
        //         power*=num;
        //     }
        //     if(power>n) break;
        //     powers.add(power);
        //     num++;
        // }
        return solve(n, x, 1);
    }
    private int solve(int n, int x, int num){
        if(n==0) return 1;
        if(n<0) return 0;
        int power=(int)Math.pow(num, x);
        if(power>n) return 0;

        int take=solve(n-power, x, num+1);
        int notTake=solve(n, x, num+1);

        return take+notTake;
    }
}