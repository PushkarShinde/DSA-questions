class Solution {
    int maxSum(int[] arr) {
        int n=arr.length;
        int sum=0;
        int curSum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            curSum+=arr[i]*i;
        }
        int res=0;
        for(int i=n-1;i>=0;i--){
            curSum=curSum+sum-n*arr[i];
            res=Math.max(res, curSum);
        }
        return res;
    }
}