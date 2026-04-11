class Solution {
    public int countIncreasing(int[] arr) {
        int n=arr.length;
        int ans=0;
        int len=1;
        boolean inc=true;
        for(int l=1;l<n;l++){
            int pre=arr[l-1];
            int cur=arr[l];
            if(pre<cur) len++;
            else{
                ans+=len*(len-1)/2;
                len=1;
            }
        }
        
        ans+=len*(len-1)/2;

        return ans;
    }
}
