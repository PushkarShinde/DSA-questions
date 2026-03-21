class Solution {

    public ArrayList<Integer> countBSTs(int[] arr) {
        int n=arr.length;
        int[] dp=new int[n+1];
        dp[0]=dp[1]=1;
        for(int node=2;node<=n;node++){
            for(int root=1;root<=node;root++){
                dp[node]+=dp[root-1]*dp[node-root];
            }
        }
        
        ArrayList<Integer> res=new ArrayList<>();
        for(int i:arr){
            int left=0;
            int right=0;
            for(int j:arr){
                if(j<i) left++;
                else if(j>i) right++;
            }
            res.add(dp[left]*dp[right]);
        }
        
        return res;
    }
    
    
}