class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int a=0, b=0;
        int n=nums1.length;
        int m=nums2.length;
        while(a<n && b<m){
            if(nums1[a]==nums2[b]) return nums1[a];
            if(nums1[a]<nums2[b]){
                a++;
            }else{
                b++;
            }
        }
        return -1;
    }
}