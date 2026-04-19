class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxLen=0;
        int n=nums1.length;
        int m=nums2.length;
        for(int i=0;i<n;i++){
            int tar=nums1[i];
            
            int l=0, r=m-1;
            int ans=0;//lowerbound
            while(l<=r){
                int mid=l+(r-l)/2;
                if(nums2[mid]>=tar){
                    ans=mid;
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
            if(i<=ans){
                maxLen=Math.max(maxLen, ans-i);
            }
        }
        return maxLen;
    }
}