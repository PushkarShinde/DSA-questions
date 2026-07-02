class Solution {
    int[][] dp;
    public boolean divisibleByK(int[] arr, int k) {
        int n=arr.length;
        
        if(n>=k) return true;
        
        boolean[] dp=new boolean[k];
        //dp[i]=true if there exists a subset whose sum modulo k is i
        for(int num: arr){
            int v=num%k;
            if(v==0) return true;
            
            boolean[] ndp=dp.clone();
            ndp[v]=true;
            
            for(int i=0;i<k;i++){
                if(dp[i]){
                    ndp[(i+v)%k]=true;
                }
            }
            
            if(ndp[0]) return true;
            
            dp=ndp;
        }
        
        return false;
    }
}