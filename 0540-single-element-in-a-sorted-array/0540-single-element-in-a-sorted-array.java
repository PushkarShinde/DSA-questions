class Solution {
    public int singleNonDuplicate(int[] nums) {
        /*
        The key idea is:
            1. Every element appears twice except one.
            2. The first instance of the pair is always at even index, 
            and the second at odd index, before the single element.
            3. After the single element, the pattern breaks.
         */
        int n=nums.length;
        int l=0, r=n-1;
        if(n==1) return nums[0];
        while(l<r){
            int mid=l+(r-l)/2;
            // Ensure mid is even
            if (mid % 2 == 1) mid--;

            // Compare pair
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2; // move right
            } else {
                r = mid; // move left
            }
        }
        return nums[l];
    }
}