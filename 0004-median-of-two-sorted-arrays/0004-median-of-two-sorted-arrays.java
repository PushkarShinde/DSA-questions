class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length, m=nums2.length;
        int total=n+m;
        int left=(total-1)/2;
        int right=total/2;

        int i=0, j=0;
        int a=0, b=0;
        int ind=-1;
        while(i<n || j<m){
            int num;
            if(j==m || (i<n && nums1[i]<=nums2[j])){
                num=nums1[i++];
            }else{
                num=nums2[j++];
            }

            ind++;
            if(left==ind){
                a=num;
            }
            if(right==ind){
                b=num;
                break;
            }
        }

        if((total&1)==1) return b;
        return (a+b)/2.0;
    }
}