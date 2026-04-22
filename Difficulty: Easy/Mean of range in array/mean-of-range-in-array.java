class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n=arr.length;
        int[] pre=new int[n];
        pre[0]=arr[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+arr[i];
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int[] q:queries){
            int l=q[0], r=q[1];
            int sum=pre[r]-(l==0?0:pre[l-1]);
            res.add(sum/(r-l+1));
        }
        return res;
    }
}