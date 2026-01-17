class Solution {
    private static int[][] dp;
    static Boolean isSubsetSum(int arr[], int sum) {
        dp=new int[arr.length+1][sum+1];//dp[i][j]=
        
        for(int i=0;i<=arr.length;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return solve(arr,sum, 0,0);
    }
    private static boolean solve(int arr[], int sum, int curSum, int i){
        if(curSum>sum) return false;
        if(curSum==sum) return true;
        
        if(dp[i][curSum]!=-1) return dp[i][curSum]==1;
        
        boolean res=false;
        if(i<arr.length){
            res=res || solve(arr,sum,curSum+arr[i],i+1);
            res=res || solve(arr,sum,curSum,i+1);
        }
        dp[i][curSum]=res?1:0;
        
        return res;
    }
}