class Solution {
    //TC- O(n^2)
    // public int maxArea(int[] height) {
    //     int n=height.length;
    //     int max=0;
    //     for(int i=0;i<n-1;i++){
    //         for(int j=n-1;j>i;j--){
    //             max=Math.max(Math.min(height[i],height[j])*(j-i),max);
    //         }
    //     }
    //     return max;
    // }
    public int maxArea(int[] height) {
        int n=height.length;
        int l=0, r=n-1;
        int max=0;
        while(l<r){
            int hl=height[l];
            int hr=height[r];
            int w=Math.min(hl,hr)*(r-l);
            max=Math.max(max,w);
            if(hl<hr){
                while(l<r && hl>=height[l]){
                    l++;
                }
            }else{
                while(l<r && height[r]<=hr){
                    r--;
                }
            }
        }
        return max;
    }
}