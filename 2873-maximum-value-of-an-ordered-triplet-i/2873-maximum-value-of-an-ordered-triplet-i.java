class Solution {
    public long maximumTripletValue(int[] nums) {
        // nums[i] aur nums[k] ki values badi honi chahiye, nums[j] chota hona chahiye

        // hums ab har j k liye uske leftmax (nums[i] max) aur rightmax (nums[k] max) preprocess karenge
        int n=nums.length;
        int[] lmax=new int[n];
        int[] rmax=new int[n];
        lmax[0]=0; // iska pehla zero hoga kyuki j=0 ke pehle i toh -1 hua, aur vo toh exist hi nahi karta toh compare kisse kare
        rmax[n-1]=0; // isko end se shuru karenge
        for(int j=1;j<n;j++){
            lmax[j]=Math.max(lmax[j-1],nums[j-1]);
        }
        for(int j=n-2;j>=0;j--){
            rmax[j]=Math.max(rmax[j+1],nums[j+1]);
        }
        long res=Long.MIN_VALUE;
        for(int j=0;j<n;j++){
            res=Math.max(res, (long)(lmax[j]-nums[j])*rmax[j]);
        }
        return res;
        /*
        TC- O(n)
        SC- O(n)
        */

        /*
        TC-O(n) SC-O(1)

        int n = nums.length;
        if (n < 3) return 0; // No valid triplet possible
        long res = 0;
        int imax = 0, dmax = 0;
        for (int num: nums) {
            res = Math.max(res, (long) dmax * num);
            dmax = Math.max(dmax, imax - num);
            imax = Math.max(imax, num);
        }
        return res;
        */
    }
}