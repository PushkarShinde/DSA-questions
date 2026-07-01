class Solution {
    public int maxSumSubarray(int[] arr) {
        int n=arr.length;
        
        int take=arr[0];
        int skip=Integer.MIN_VALUE;
        int res=arr[0];
        for(int i=1;i<n;i++){
            if(skip!=Integer.MIN_VALUE){
                skip=Math.max(take, skip+arr[i]);
            }else{
                skip=take;
            }
            
            take=Math.max(arr[i], take+arr[i]);
            res=Math.max(res, Math.max(take, skip));
        }
        return res;
    }
}