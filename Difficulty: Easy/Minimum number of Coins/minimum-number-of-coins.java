// User function Template for Java

class Solution {
    
    static List<Integer> minPartition(int N) {
        List<Integer> res=new ArrayList<>();
        int[] deno=new int[]{ 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        for(int i=deno.length-1;i>=0;i--){

            if(deno[i]<=N){
                int n=N/deno[i];
                N-=deno[i]*n;
                for(int j=0;j<n;j++){
                    res.add(deno[i]);
                }
            }
        }
        return res;
    }
}