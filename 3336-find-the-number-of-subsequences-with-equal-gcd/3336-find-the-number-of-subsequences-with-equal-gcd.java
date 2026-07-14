class Solution {
    private long mod=(long)1e9+7;
    private int[][][] dp;
    private int max=201;

    public int subsequencePairCount(int[] nums){
        int n=nums.length;

        dp=new int[n][max][max];
        for(int[][] k:dp){
            for(int[] d: k){
                Arrays.fill(d,-1);
            }
        }

        return (int)solve(nums, 0, 0, 0);
    }

    private int solve(int[] nums, int i, int x, int y){
        int n=nums.length;
        if(i==n){
            return (x==y && x>0)?1:0;
        }

        if(dp[i][x][y]!=-1) return dp[i][x][y];

        int gx=(x==0?nums[i]:gcd(x,nums[i]));
        int gy=(y==0?nums[i]:gcd(y,nums[i]));

        long res=0;
        res=(res+solve(nums, i+1, gx, y))%mod;
        res=(res+solve(nums, i+1, x, gy))%mod;
        res=(res+solve(nums, i+1, x, y))%mod;

        return dp[i][x][y]=(int)res;
    }

    private int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}