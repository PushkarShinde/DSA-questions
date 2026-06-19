class Solution{
    public ArrayList<Integer> optimalArray(int[] arr) {
        int n=arr.length;
        ArrayList<Integer> res=new ArrayList<>();
        int total=0, sum=0;
        
        long[] pre=new long[n+1];
        for(int i=1;i<=n;i++) pre[i]=pre[i-1]+arr[i-1];
        
        for(int i=0; i<n; i++){
            int cur=arr[i];
            int m=i/2;
            int med=arr[m];
            
            long leftSum=med*(m+1)-pre[m+1];
            long rightSum=(pre[i+1]-pre[m+1])-med*(i-m);
            res.add((int)(leftSum+rightSum));
        }
        
        return res;
    }
}