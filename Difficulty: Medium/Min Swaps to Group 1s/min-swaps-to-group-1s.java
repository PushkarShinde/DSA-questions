class Solution {
    int[] pre;
    //1 0 1 0 1 1 1 1 1 0 1 0
    public int minSwaps(int[] arr) {
        int n=arr.length;
        int one=0;
        for(int a:arr){
            one+=a;
        }
        if(one==0) return -1;
        
        int cur=0;
        for(int i=0;i<one;i++){
            cur+=arr[i];
        }
        
        int maxOnes=cur;
        for(int i=one;i<n;i++){
            cur+=arr[i];
            cur-=arr[i-one];
            maxOnes=Math.max(maxOnes, cur);
        }
        return one-maxOnes;
    }
}
