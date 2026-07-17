class Solution {
    public int maxDiffSubArrays(int[] arr) {
        int n=arr.length;

        int[] leftMax=new int[n]; 
        int[] leftMin=new int[n]; 
        int[] rightMax=new int[n]; 
        int[] rightMin=new int[n];
        
        int curMax=arr[0];
        int curMin=arr[0];
        leftMax[0]=curMax;
        leftMin[0]=curMin;
        for(int i=1;i<n;i++){
            curMax=Math.max(arr[i], curMax+arr[i]);
            leftMax[i]=Math.max(leftMax[i-1], curMax);
            
            curMin=Math.min(arr[i], curMin+arr[i]);
            leftMin[i]=Math.min(leftMin[i-1], curMin);
        }
        
        curMax=arr[n-1];
        curMin=arr[n-1];
        rightMax[n-1]=curMax;
        rightMin[n-1]=curMin;
        for(int i=n-2;i>=0;i--){
            curMax=Math.max(arr[i], curMax+arr[i]);
            rightMax[i]=Math.max(rightMax[i+1], curMax);
            
            curMin=Math.min(arr[i], curMin+arr[i]);
            rightMin[i]=Math.min(rightMin[i+1], curMin);
        }
        
        int res=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            res=Math.max(res, 
                Math.max(
                    Math.abs(leftMax[i]-rightMin[i+1]), 
                    Math.abs(leftMin[i]-rightMax[i+1])
                )
            );
        }
        
        return res;
    }
}