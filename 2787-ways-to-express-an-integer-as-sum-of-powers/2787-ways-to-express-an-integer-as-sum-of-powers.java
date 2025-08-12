class Solution {
    private static final int mod=(int)1e9+7;
    private static int[][] memo=new int[301][301];
    public int numberOfWays(int n, int x) {
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
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
        // Arrays.fill(memo, -1);
        if(n==0) return 1;
        if(n<0) return 0;
        int power=intPow(num, x);
        if(power>n) return 0;
        if(memo[n][num]!=-1) return memo[n][num];
        int take=solve(n-power, x, num+1);
        int notTake=solve(n, x, num+1);

        return memo[n][num]=(take+notTake)%mod;
    }
    private int intPow(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }
}