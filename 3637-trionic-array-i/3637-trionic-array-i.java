class Solution {
    public boolean isTrionic(int[] nums) {
        int i=1;
        int n=nums.length;
        boolean inc=false;
        boolean dec=false;
        while(i<n && nums[i]>nums[i-1]){
            i++;
            inc=true;
        }
        if(i==n || !inc) return false;
        while(i<n && nums[i]<nums[i-1]){
            i++;
            dec=true;
        }
        if(i==n || !dec) return false;
        inc=false;
        while(i<n){
            if(nums[i]<=nums[i-1]) return false;
            i++;
        }
        return i==n;
    }
}